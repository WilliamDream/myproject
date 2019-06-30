package com.william.tomcat.http;

import java.io.InputStream;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/6/28 7:27
 */
public class MyRequest {

    private String method;

    private String url;


    public MyRequest(InputStream inputStream){
        try {
            String content = "";
            byte[] buff = new byte[1024];
            int len = 0;
            if((len = inputStream.read(buff))>0){
                content = new String(buff,0,len);
            }

            String s = content.split("\\n")[0];
            String [] arr = s.split("\\s");

            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
