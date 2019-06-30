package com.william.tomcat.http;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/6/28 9:24
 */
public abstract class MyServlet {

    public void service(MyRequest request,MyResponse response)throws Exception{
        if("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }

    public abstract void doGet(MyRequest request,MyResponse response) throws Exception;

    public abstract void doPost(MyRequest request,MyResponse response) throws Exception;

}
