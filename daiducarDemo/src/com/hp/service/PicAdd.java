package com.hp.service;

import java.io.IOException;
import java.net.URLEncoder;

import com.hp.utils.Base64Util;
import com.hp.utils.FileUtil;
import com.hp.utils.HttpUtil;

public class PicAdd {
	public static String pAdd() throws Exception{
	//����һ��URL
	 String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
    
         // �����ļ�·�� ��һ��ͼƬ
         String filePath = "C:\\Users\\Administrator\\Desktop\\chepai.jpg";
         
         //Ȼ�� ��ȡ����ͼƬ
         byte[] imgData = FileUtil.readFileByBytes(filePath);
         
         //base64ת��
         String imgStr = Base64Util.encode(imgData);
         
         //��URL ��Ϊutf-8
         String imgParam = URLEncoder.encode(imgStr, "UTF-8");
         //System.out.println("imgParam:"+imgParam);
         
         
         //ƴ�Ӳ���
         String param = "&image_type=BASE" + "&image=" + imgParam ;
         AuthService auth = new AuthService();
         
         // ��ȡtoken
         String accessToken = auth.getAuth();
         
         //����������ַ��
         String result = HttpUtil.post(url, accessToken, param);
         System.out.println("picAdd:"+result);
         
         return result;
   
 
}
}
