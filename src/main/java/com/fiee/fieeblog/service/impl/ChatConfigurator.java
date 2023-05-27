package com.fiee.fieeblog.service.impl;

/**
 * @Author: Fiee
 * @ClassName: ChatConfigurator
 * @Date: 2023/4/17
 * @Version: v1.0.0
 **/

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 获取客户端真实ip
 */
public class ChatConfigurator extends ServerEndpointConfig.Configurator {

    public static String HEADER_NAME = "X-Real-IP";

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        try {
            String firstFoundHeader = request.getHeaders().get(HEADER_NAME.toLowerCase()).get(0);
            sec.getUserProperties().put(HEADER_NAME, firstFoundHeader);
        } catch (Exception e) {
            sec.getUserProperties().put(HEADER_NAME, "未知ip");
        }
    }
}