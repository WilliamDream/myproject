package com.william.tomcat.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/6/30 11:36
 */
public class MyRequest {

    private ChannelHandlerContext ctx;

    private HttpRequest request;

    public MyRequest(ChannelHandlerContext ctx, HttpRequest request) {
        this.ctx = ctx;
        this.request = request;
    }








}
