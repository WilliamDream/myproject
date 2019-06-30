package com.william;

import com.william.tomcat.http.MyRequest;
import com.william.tomcat.http.MyResponse;
import com.william.tomcat.http.MyServlet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/6/28 7:20
 */
public class Mytomcat {


    //1.配置启动端口，默认8080
    private int port = 8080;

    private ServerSocket server;

    private Map<String,MyServlet> servletMap = new HashMap<>();

    private Properties webxml = new Properties();

    private void initConfig(){
        try {
            String PATH = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(PATH+"web.properties");
            webxml.load(fis);
            //3.读取配置，url-pattern 和Servlet 建立映射关系
            for (Object key : webxml.keySet()){
                String k = key.toString();
                if(k.endsWith(".url")){
                    String servletName = k.replaceAll("\\.url$","");
                    String url = webxml.getProperty(k);
                    String className = webxml.getProperty(servletName + ".className");
                    MyServlet servlet = (MyServlet) Class.forName(className).newInstance();
                    servletMap.put(url,servlet);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public void start(){
        //2.配置web.xml
        initConfig();

        try {
            server = new ServerSocket(this.port);

            //死循环等待请求
            while (true){
                //阻塞的
                Socket socket = server.accept();
                process(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //4.Http请求

    private void process(Socket socket) throws  Exception{
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        MyRequest myRequest = new MyRequest(is);
        MyResponse myResponse = new MyResponse(os);

        String url = myRequest.getUrl();

        if(servletMap.containsKey(url)){
            //5.从协议中获取url，把相应的servlet通过反射
            servletMap.get(url).service(myRequest,myResponse);
        }else {
            myResponse.write("404--网页被外星人劫持了!");
        }

        os.flush();
        os.close();
        is.close();

        socket.close();
    }

    public static void main(String[] args) {
        new Mytomcat().start();
    }

}
