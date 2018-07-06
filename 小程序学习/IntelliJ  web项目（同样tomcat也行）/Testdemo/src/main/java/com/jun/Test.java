package com.jun;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/7/6/006.
 */
@RestController
public class Test {
    @RequestMapping(value = "getBaseCode",method = RequestMethod.POST,headers = "Accept=application/json")
    public String getBaseCode(@RequestParam("file") MultipartFile file){
        //获取图片64位字节码
        try {
            InputStream inputStream = file.getInputStream();
            //讲流转成字节数组
            byte[] data=new byte[inputStream.available()];
            //读取
            inputStream.read(data);
            System.out.print(data);
            //关闭流
            inputStream.close();
            //转码
            BASE64Encoder base=new BASE64Encoder();
            String encode = base.encode(data);
            return encode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
