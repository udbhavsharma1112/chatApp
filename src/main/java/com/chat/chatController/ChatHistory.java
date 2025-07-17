package com.chat.chatController;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttClient;

import com.chat.api.UserChatInfo;
import com.chat.auth.User;
import com.chat.messageQueue.MqttClientManager;
import com.chat.messageQueue.MqttPublisher;
import com.chat.model.MessageHistory;

public class ChatHistory {
    private User user;
    private MqttClientManager clientManager;
    private MqttClient client;
    private MqttPublisher publisher;

    public ChatHistory(User user) {
        this.user = user;
        this.clientManager = new MqttClientManager(this.user.getUserId());
        this.client = clientManager.getClient();
        this.publisher = new MqttPublisher(this.client);
    }

    public List<MessageHistory> getChatHistory(User selectedUser) {
        UserChatInfo userChatInfo = new UserChatInfo();
        if (selectedUser == null || selectedUser.getUserId() == null) {
            System.out.println("Selected user or user ID is null.");
            return new ArrayList<>();
        }
        return userChatInfo.getChatHistory(selectedUser.getUserId());
    }

    public void printChatHistory(User selectedUser) {
        System.out.println("Chat History for User: " + selectedUser.getUserName());
        List<MessageHistory> chatHistory = this.getChatHistory(selectedUser);
        if(chatHistory.isEmpty()) {
            System.out.println("No chat history found for user: " + selectedUser.getUserName());
            System.out.println("You can start typing to chat with this user.");
            return;
        }
        chatHistory.forEach(message -> {
            if (message instanceof MessageHistory) {
                MessageHistory textMessage = (MessageHistory) message;
                String viewSpace = "";
                if (!textMessage.getSenderName().equals(user.getUserName())) {
                    viewSpace = "                                                                      ";
                }
                System.out.println(viewSpace + textMessage.getSenderName() + ": " + textMessage.getMessage());
            }
        });
    }
}
