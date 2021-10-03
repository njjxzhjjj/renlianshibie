package com.hp.service;

import java.io.IOException;
import java.net.URLEncoder;

import com.hp.utils.Base64Util;
import com.hp.utils.FileUtil;
import com.hp.utils.HttpUtil;

public class PicAdd {
	public static String pAdd() throws Exception{
	//请求一个URL
	 String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
    
         // 本地文件路径 的一张图片
         String filePath = "C:\\Users\\Administrator\\Desktop\\chepai.jpg";
         
         //然后 读取这张图片
         byte[] imgData = FileUtil.readFileByBytes(filePath);
         
         //base64转码
         String imgStr = Base64Util.encode(imgData);
         
         //让URL 成为utf-8
         String imgParam = URLEncoder.encode(imgStr, "UTF-8");
         //System.out.println("imgParam:"+imgParam);
         
         
         //拼接参数
         String param = "&image_type=BASE" + "&image=" + imgParam ;
         AuthService auth = new AuthService();
         
         // 获取token
         String accessToken = auth.getAuth();
         
         //可以请求网址啦
         String result = HttpUtil.post(url, accessToken, param);
         System.out.println("picAdd:"+result);
         
         return result;
   
 
}
}
