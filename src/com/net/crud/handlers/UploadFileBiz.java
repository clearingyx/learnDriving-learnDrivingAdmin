package com.net.crud.handlers;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

import sun.misc.BASE64Decoder;

import com.net.util.DateUtil;
import com.net.util.FileUtil;
import com.net.util.PathUtil;


public class UploadFileBiz {
	
   /**
    * 上传图片
    * @param fileBase64Str   图片 strng格式
    * @param type  文件类型
    */
  public static String Upload(String fileBase64Str,UploadFileType type)
  {
	  //获取到项目根目录
	  String appPath = PathUtil.AppPath;
	  
	  
	  //生成文件名，目前占时支持".png"
	  String fileName = UUID.randomUUID().toString();
	  //拼接成文件保存路径
	  String savePaht = appPath+"//"+type.toString()+"//"+fileName +".png";
	  //开始上传
	  FileUtil.Upload(fileBase64Str, savePaht);
	  return fileName;
  }
  /**
   * 上传图片
   * @param fileBase64Str   图片 strng格式     author:wt
   * @param type  文件类型        返回图片名称
   */
 public static String Upload1(String fileBase64Str,String path,String appPath,String proPath)
 {
	  //生成文件名，目前暂时支持".png"
	  String fileName = DateUtil.getDays()+"-"+UUID.randomUUID().toString();
	  //拼接成文件保存路径
	  //String savePaht = appPath+"//"+type.toString()+"//"+fileName +".png";
	  String savePath = appPath+"//"+path+"//"+fileName+".png";
	  //http://localhost:8080/learnDriving/upload/person/person4.jpg
	  //开始上传
	  FileUtil.Upload(fileBase64Str, savePath);
	  //return GetFileName()+"/"+path+"/"+fileName;
	  return proPath+"/"+savePath;
 }

	// base64字符串转化成图片
	public static String Upload(String imgStr,String path,String appPath,String proPath) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return "fail";
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			String fileName = DateUtil.getDays()+"-"+UUID.randomUUID().toString().replace("-", "")+".png";
			String savePath = appPath+"//"+path+"//"+fileName;
			// 生成jpeg图片
			String imgFilePath = savePath;// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return proPath+path+"/"+fileName;
		} catch (Exception e) {
			return "fail";
		}
	}

  /**
   * 获取图片保存路径
   * @param fileName  数据库中文件名
   * @param type  存储类型
   * @return
   */
  public static String GetUploadPath(String fileName,UploadFileType type)
  {
	  //获取到项目根目录
	  String appPath = PathUtil.AppPath;
	  //拼接成文件保存路径
	  String savePaht = appPath+"//"+type.toString()+"//"+fileName +".png";
	  return savePaht;
  }
  /**
   * 项目名称+upload
   * @return
   */
  public static String GetFileName()
  {
	  ResourceBundle rb = ResourceBundle.getBundle("config");
	  return rb.getString("domain");
  }
  
  /*
   * 存储音频
   */
  public static String UploadSound(String fileBase64Str,UploadFileType type,String appPath)
 {
	  //生成文件名，目前占时支持".wma"
	  String fileName = UUID.randomUUID().toString();
	  //拼接成文件保存路径
	  //String savePaht = appPath+"//"+type.toString()+"//"+fileName +".png";
	  String savePaht = appPath+"//"+type.toString()+"//"+fileName +".wma";
	  //开始上传
	  FileUtil.Upload(fileBase64Str, savePaht);
	  return GetFileName()+"/"+type.toString()+"/"+fileName;
	  
  }
}
