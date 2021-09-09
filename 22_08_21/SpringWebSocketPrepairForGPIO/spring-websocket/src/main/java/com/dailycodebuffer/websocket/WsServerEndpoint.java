package com.dailycodebuffer.websocket;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.Writer;

@Component
@ServerEndpoint("/myWs")
public class WsServerEndpoint {
    DistanceSensor distanceSensor = new DistanceSensor();
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Successful connection");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection closure");
    }


   @OnMessage
   public void gerade(String text, Session session) throws InterruptedException, IOException {

	   for(int i = 0; i<100;i++) {
           double DoubleValue = DistanceSensor.measure();
           int wasserstandInt = (int) Math.round(DoubleValue);

               LED.an();
                Thread.sleep(500);
                session.getBasicRemote().sendText("<div class =\"wasserstandwert\" >"+wasserstandInt+"</div>"+
                        "<style> .child3 {opacity:0.5;width:100%;height: 100%;top:"+wasserstandInt+"%;left:1%;background-color: aqua;position: absolute;}</style>");
                LED.aus();
           Thread.sleep(500);



	   }
   }
}