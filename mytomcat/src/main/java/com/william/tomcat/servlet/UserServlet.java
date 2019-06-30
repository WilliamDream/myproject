package com.william.tomcat.servlet;

import com.william.tomcat.http.MyRequest;
import com.william.tomcat.http.MyResponse;
import com.william.tomcat.http.MyServlet;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/6/30 10:07
 */
public class UserServlet extends MyServlet {

    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        this.doPost(request,response);
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("UserServlet response context");
    }
}
