package com.chat.chatController;
import com.chat.auth.User;
import com.chat.messageQueue.*;
import java.util.Scanner;
import org.eclipse.paho.client.mqttv3.*;

public class ChatSession implements MessageListener{
    Scanner scanner = new Scanner(System.in);
    private User user;
    private User receiverUser;
    private MqttClientManager clientManager;
    private MqttClient client;
    private MqttPublisher publisher;
    private final MqttSubscriber subscriber;
    

    public ChatSession(User user) {
        this.user = user;
        this.clientManager = new MqttClientManager(user.getEmail());
        this.client = clientManager.getClient();
        this.client.setCallback(new MqttMessageHandler(user.getEmail(), this));
        this.publisher = new MqttPublisher(this.client);
        this.subscriber = new MqttSubscriber(this.client);
    }

    public void setReceiverUser(User user) {
        this.receiverUser = user;
    }
    public void start() {
        clientManager.connect();
        String topic = "user/" + user.getEmail();
        subscriber.subscribe(topic);
        System.out.println("✅ Connected and subscribed to " + topic);

        while(true) {
            System.out.print(">> ");
            String messageContent = scanner.nextLine();
            sendMessage(new TextMessage(user, receiverUser, messageContent));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("❌ Error in sending message: " + e.getMessage());
            }
        }
    }

    
    public void sendMessage(IMessage message) {
        if(receiverUser != null) {
            message.showSenderMessage();
            String topic = "user/" + receiverUser.getEmail();
            publisher.sendMessage(topic, message.getSerializedContent());
        } else{
            System.out.println("❌ No receiver user set. Please set a receiver user before sending a message.");
        }
    }

    public void stop() {
        clientManager.disconnect();
    }

    @Override
    public void onMessageReceived(String topic, String message) {
        IMessage msg = IMessage.deserializeMessage(message);
        if (msg != null) {
            msg.showReceiverMessage();
        }
    }
}
