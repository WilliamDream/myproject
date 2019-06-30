package com.william.tomcat.http;

import java.io.OutputStream;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/6/28 9:26
 */
public class MyResponse {

    private OutputStream os;

    public MyResponse(OutputStream os) {
        this.os = os;
    }

    public void write(String res) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-Type: text/html;\n");
        sb.append("\r\n");
        sb.append(res);

        os.write(sb.toString().getBytes());
    }

}
