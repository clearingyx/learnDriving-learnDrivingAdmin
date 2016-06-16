package com.net.util;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

/**
 * @包名 com.net.util
 * @类名 JPushClientUtil
 * @作者 snail
 * @创建时间 2015-10-19
 * @描述 TODO
 */
public class JPushClientUtil {

    protected static final Logger LOG = LoggerFactory.getLogger(JPushClientUtil.class);

    private static final String appKey = "4808bb9b8c35cffc8a93ec59"; // 必填，例如466f7032ac604e02fb7bda89

    private static final String masterSecret = "7b121eac09fa2893c711e571";// "13ac09b17715bd117163d8a1";//必填，每个应用都对应一个masterSecret

    private static JPushClient jpush = null;

    public static final int MAX = Integer.MAX_VALUE;

    public static final int MIN = (int) MAX / 2;

    private static int maxRetryTimes = 3;

    private static void init() {
        jpush = new JPushClient(masterSecret, appKey, maxRetryTimes);
    }

    /**
     * @方法名 pushMessage
     * @方法描述 根据别名推送消息
     * @返回类型 void
     * @参数 msgTitle 推送标题
     * @参数 msgContent 消息内容
     * @参数 alias 接收推送的别名
     * @参数 extrasMap 推送需要的参数树
     * @创建日期 2015-10-19
     */
    public static void pushMessage(String msgTitle, String msgContent, String alias,
            Map<String, String> extrasMap) {
        init();
        PushPayload payload = buildPushObject_alias_alertWithTitle(msgTitle, msgContent, alias,
                extrasMap);
        SendPush(jpush, payload);
    }

    /**
     * 构建PushPayload对象
     * @param content消息内容
     * @param title标题
     * @param alias 别名--用户id或手机号
     * @return
     */
    private static PushPayload buildPushObject_alias_alertWithTitle(String title, String content,
            String alias, Map<String, String> extrasMap) {
        return PushPayload.newBuilder().setPlatform(Platform.android_ios()).setAudience(
                Audience.alias(alias)).setNotification(Notification.ios(content, extrasMap))
                .setNotification(Notification.android(content, title, extrasMap)).build();
    }

    /**
     * @方法名 发送消息
     * @方法描述 (描述此方法作用)
     * @返回类型 void 
     * @创建日期 2015-10-19
     */
    private static void SendPush(JPushClient jPushClient, PushPayload payload) {
        try {
            PushResult result = jPushClient.sendPush(payload);
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
    }
}
