package com.net.common.handlers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.ActionEnter;
import com.net.common.UEditorResponse;
import com.net.util.PathUtil;
import com.net.util.UploadFileNameDefineUtil;

/**
 * @包名 com.net.common.handlers
 * @类名 UEditorController
 * @作者 snail
 * @创建时间 2015-10-23
 * @描述 TODO
 */
@Controller
public class UEditorController {

    private static Logger log = Logger.getLogger(UEditorController.class);

    @RequestMapping(value = "UEditorConfig", produces = { "text/html;charset=utf-8" })
    @ResponseBody
    public Object UEditorConfig(HttpServletRequest request, String action) {
        log.info(action);
        return new ActionEnter(request, PathUtil.GetAppRealPath(request)).exec();
    }

    @RequestMapping("UEditorUploadImage")
    @ResponseBody
    public Object UEditorUploadImage(@RequestParam MultipartFile upfile, HttpServletRequest request) {
        String newname = null;
        if (upfile.isEmpty()) {
            log.info("文件未上传");
        } else {
            log.info("文件长度: " + upfile.getSize() + "文件类型: " + upfile.getContentType() + "文件名称: "
                    + upfile.getName() + "文件原名: " + upfile.getOriginalFilename());
            //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\
            //文件夹中这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用
            //到的IO流关掉，我是看它的源码才知道的
            try {
                newname = UploadFileNameDefineUtil.DefineUploadFileName(upfile.getOriginalFilename());
                FileUtils.copyInputStreamToFile(upfile.getInputStream(), new File(PathUtil
                        .GetAppRealPath(request)
                        + "/upload/image/", newname));
            } catch (IOException e) {
                log.error("图片上传出现异常\n" + e.getMessage());
            }
        }
        return new UEditorResponse("SUCCESS", "upload/image/" + newname,
                newname, newname);
    }
}
