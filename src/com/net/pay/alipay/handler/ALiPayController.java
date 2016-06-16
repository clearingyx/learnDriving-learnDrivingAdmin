package com.net.pay.alipay.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.net.crud.handlers.BaseHandler;
import com.net.crud.handlers.OrdersHandler;
import com.net.pay.alipay.util.AlipayNotify;

/**
 * @包名 com.net.pay.alipay.handler
 * @类名 ALiPayController
 * @作者 snail
 * @创建时间 2015-8-22
 * @描述 支付宝支付回调、退款请求、退款回调、转账请求、转账回调
 */
@RequestMapping(value = "ALiPay", produces = "text/html;charset=utf-8")
@Controller
public class ALiPayController extends BaseHandler{

    private static Logger log = Logger.getLogger(ALiPayController.class);
	@Autowired
	OrdersHandler ordersHandler;
    /* *
     * 功能：支付宝服务器异步通知页面
     * 版本：3.3
     * 日期：2012-08-17
     * 说明：
     * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
     * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
     * //***********页面功能说明***********
     * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
     * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
     * 该页面调试工具请使用写文本函数logResult，该函数在com.alipay.util文件夹的AlipayNotify.java类文件中
     * 如果没有收到该页面返回的 success 信息，支付宝会在24小时内按一定的时间策略重发通知
     * //********************************
     */
    @RequestMapping(value = "AfterPayNotify", method = RequestMethod.POST)
    
     /* 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表
     * 商户订单号 out_trade_no
     * 支付宝交易号 trade_no
     * 交易状态 trade_status
     * */
     
    public void ALiPayNotify(HttpServletRequest request, String out_trade_no, String trade_no,
            String trade_status, PrintWriter out,HttpSession session) {

        //获取支付宝POST过来反馈信息
        Map<String, String> params = GetInfoFromALiPay(request);

        if (AlipayNotify.verify(params)) {
            //验证成功
            if (trade_status.equals("TRADE_FINISHED") | trade_status.equals("TRADE_SUCCESS")) {
            	//修改各种成功状态            	
            	ordersHandler.PaySuccess(out_trade_no,trade_no);
            	out.println("success");
            }                
        } else {
        	log.error("支付失败！");
        	//修改各种失败状态
        	ordersHandler.PayFail(out_trade_no);
            //验证失败
            out.println("fail");
        }
    }

    /*@RequestMapping(value = "ALiPayRefund", method = RequestMethod.POST)
    //退款订单号，发起退款操作人角色类型：1平台2区域3商家，发起人手机号
    public void ALiPayRefund(OrderComplaint oc, PrintWriter out,HttpSession session) {
    	
        //服务器异步通知页面路径
        String notify_url = rb.getString("pay_notice") + "ALiPay/RefundNotify";

        //卖家支付宝帐户
        String seller_email = AlipayConfig.seller_email;
        //必填

        //退款当天日期
        String refund_date = DateUtil.getTime();
        //必填，格式：年[4位]-月[2位]-日[2位] 小时[2位 24小时制]:分[2位]:秒[2位]，如：2007-10-01 13:13:13

        Orders orders=orders_dao.selectByOc(oc.getId());

        //批次号
        String batch_no = DateUtil.getDays() + DateUtil.getDayMsec().substring(8);
        //必填，格式：当天日期[8位]+序列号[3至24位]，如：201008010000001

        //退款笔数
        String batch_num = "1";
        //必填，参数detail_data的值中，“#”字符出现的数量加1，最大支持1000笔（即“#”字符出现的数量999个）

        //退款详细数据
        oc.setResult("管理员同意您的退款申请，退款原因："+oc.getResult());
        String detail_data = orders.getAlipayordersn() + "^" + orders.getPayment() + "^" + oc.getResult();
        //必填，具体格式请参见接口技术文档

        //把请求参数打包成数组
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "refund_fastpay_by_platform_pwd");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp.put("notify_url", notify_url);
        sParaTemp.put("seller_email", seller_email);
        sParaTemp.put("refund_date", refund_date);
        sParaTemp.put("batch_no", batch_no);
        sParaTemp.put("batch_num", batch_num);
        sParaTemp.put("detail_data", detail_data);
        //建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
        //订单、投诉状态更新
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("oc", new OrderComplaint(oc.getId(), oc.getState(), oc.getResult(),new Date(),batch_no));
        map.put("orders", new Orders(orders.getId(), 4));
        map.put("persion", new Persion(orders.getBuyId(),orders.getGlod()));
        session.setAttribute("backMap", map);
       
        //if (a>0 && b>0) {	       	        
            out.println(sHtmlText);
        } else{
            log.error("状态更新出错，没有确认退款，请核对后再试！");
            out.println("error");
        }
    }

     *
     * 功能：支付宝服务器异步通知页面
     * 版本：3.3
     * 日期：2012-08-17
     * 说明：
     * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
     * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
     * //***********页面功能说明***********
     * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
     * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
     * 该页面调试工具请使用写文本函数logResult，该函数在com.alipay.util文件夹的AlipayNotify.java类文件中
     * 如果没有收到该页面返回的 success 信息，支付宝会在24小时内按一定的时间策略重发通知
     * //********************************
     
    @RequestMapping(value = "RefundNotify", method = RequestMethod.POST)
    *//**
     * 批次号 String batch_no
     * 批量退款数据中转账成功的笔数 String success_num
     * 批量退款数据中的详细信息 String result_details
     *//*
      public void RefundNotify(HttpServletRequest request, String batch_no, String success_num,
            String result_details, PrintWriter out,HttpSession session) {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = GetInfoFromALiPay(request);
        OrderComplaint oc = order_complaint_dao.selectByBatchNo(batch_no);
        if (AlipayNotify.verify(params)) {//验证成功
            if (Integer.parseInt(success_num) == 1) {         	
            	Map<String, Object> map = (Map<String, Object>) session.getAttribute("backMap");
           	   //投诉表、订单表、用户表信息修改
               int a=order_complaint_dao.state_change(map);
               if(a==0) log.error("更新投诉表、订单表、用户信息失败！");
               //3是订单，11同意退款
               int b=follow_method(new FollowMethod(3, 11, oc.getResult(), oc.getId(), getAdminId(session)));
               if(b==0) log.error("推送信息、新增日志表、状态更新失败！");
               int c=refundSuccess(oc);
               if(c==0)	log.error("退款状态更新出现异常");
            } else {
                    log.error("退款操作出现异常");
            }
            out.println("success");
        } else {
        	oc.setState(5);
        	int a = order_complaint_dao.updateByOrderPayError(oc);
        	if(a==0)
        		log.error("退款失败，订单投诉表更新失败！");
            out.println("fail");
        }
    }

  @RequestMapping(value = "ALiPayTrans", method = RequestMethod.POST)
    public void ALiPayTrans(Balance balance, PrintWriter out,HttpSession session) {

        //服务器异步通知页面路径
        String notify_url = rb.getString("pay_notice")  + "ALiPay/TransNotify";
        //需http://格式的完整路径，不允许加?id=123这类自定义参数

        //付款账号
        String email = AlipayConfig.seller_email;
        //必填

        //付款账户名
        String account_name = AlipayConfig.account_name;
        //必填，个人支付宝账号是真实姓名公司支付宝账号是公司名称

        //付款当天日期
        String pay_date = DateUtil.getDays();
        //必填，格式：年[4位]月[2位]日[2位]，如：20100801
        
        //批次号
        String batch_no = DateUtil.getDays() + DateUtil.getDayMsec().substring(8);
        balance.setBatchNo(batch_no);
        //balance.setState(4);
        balance.setAdminId((Integer)session.getAttribute("admin_id"));
        int a=balance_do_after(balance);//各种方法
        if (a>0) {

            //必填，格式：当天日期[8位]+序列号[3至16位]，如：201008010000001

            //付款总金额
            String batch_fee = Double.toString(balance.getSureAmount());
            //必填，即参数detail_data的值中所有金额的总和

            //付款笔数
            String batch_num = "1";
            //必填，即参数detail_data的值中，“|”字符出现的数量加1，最大支持1000笔（即“|”字符出现的数量999个）

            //付款详细数据
            Aliacount ali=ali_dao.selectByPersionId(balance.getSellerId());
            String detail_data = batch_no + "^" + ali.getAccount() + "^"
                    + ali.getRealname() + "^" + batch_fee + "^平台手续费" + balance.getPlatAmount();
            //必填，格式：流水号1^收款方帐号1^真实姓名^付款金额1^备注说明1|流水号2^收款方帐号2^真实姓名^付款金额2^备注说明2....

            //把请求参数打包成数组
            Map<String, String> sParaTemp = new HashMap<String, String>();
            sParaTemp.put("service", "batch_trans_notify");
            sParaTemp.put("partner", AlipayConfig.partner);
            sParaTemp.put("_input_charset", AlipayConfig.input_charset);
            sParaTemp.put("notify_url", notify_url);
            sParaTemp.put("email", email);
            sParaTemp.put("account_name", account_name);
            sParaTemp.put("pay_date", pay_date);
            sParaTemp.put("batch_no", batch_no);
            sParaTemp.put("batch_fee", batch_fee);
            sParaTemp.put("batch_num", batch_num);
            sParaTemp.put("detail_data", detail_data);
            //建立请求
            String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
            out.println(sHtmlText);
        } else {
            log.error("结算账单提交前更新出现异常，请校对排查");
        }
    }

    @RequestMapping(value = "TransNotify", method = RequestMethod.POST)
    *//**
     * 批量付款数据中转账成功的详细信息 String success_details 
     * 批量付款数据中转账失败的详细信息 String fail_details
     * 批量付款数据中转账批次号 String batch_no
     *//*
    public void TransNotify(HttpServletRequest request, String success_details, String batch_no,
            String fail_details, PrintWriter out) {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = GetInfoFromALiPay(request);
        int a=0;
        if (AlipayNotify.verify(params)) {//验证成功        	
        	a=balance_do_before(batch_no, 2);
        	if(a<=0)
        		log.error("结算成功，但是更新状态或推送信息报错！");
        	out.println("success");
        } else {//验证失败
        	a=balance_do_before(batch_no, 3);
        	if(a<=0)
        		log.error("结算失败，更新状态或推送信息报错！");
            out.println("fail");
        }
    }*/

    @SuppressWarnings("unchecked")
    public Map<String, String> GetInfoFromALiPay(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i]
                        + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        return params;
    }
}
