/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import javax.inject.Inject;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.Session;

/**
 *
 * @author Mobile Apps
 */
@ServerEndpoint("/chatDemo")
public class SimpleEndpoint {

    @Inject
    PoemGenerator generator;

    @OnMessage
    public void onMessage(String message, Session session) throws java.io.IOException, InterruptedException {

        System.out.println("Client Message " + message);

        int size = generator.getWords().size();
        Random random = new Random();

        session.getBasicRemote().sendText(generator.getWords().get(random.nextInt(size)));

        if ("all".equalsIgnoreCase("all")) {
            //session.getBasicRemote().sendText("all");
            //System.out.println("********************************");

            for(int i=0;i<20;i++){
                String p=generator.getWords().get((int)(Math.random() * size));
                session.getBasicRemote().sendText(p);
                Thread.sleep(1000);
            }
        }

        // session.close();
    }
}
