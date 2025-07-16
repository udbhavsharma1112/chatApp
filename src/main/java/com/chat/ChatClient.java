package com.chat;

import com.chat.auth.User;
import com.chat.auth.VerifyUser;
import com.chat.chatController.ChatManager;
import com.chat.utils.ApiCaller;
import java.io.File;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ChatClient {

    private ChatAppConfiguration config;

    public void start() {

        try {
            // Load config from config.yml
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                config = mapper.readValue(new File("config.yml"), ChatAppConfiguration.class);
                // use config.getBaseUrl(), etc.
            } catch (Exception e) {
                System.err.println("❌ Failed to load configuration: " + e.getMessage());
                e.printStackTrace();
            }

            Client client = ClientBuilder.newClient();

            // Set your base URL here (can also come from config)
            String baseUrl = config.getBaseUrl();

            // Initialize the API Caller
            ApiCaller.init(client, baseUrl);

            // Verify user and start chat
            VerifyUser verifyUser = new VerifyUser();
            User user = verifyUser.verify();

            ChatManager chatManager = new ChatManager(user);
            chatManager.start();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Failed to load configuration");
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }
}
