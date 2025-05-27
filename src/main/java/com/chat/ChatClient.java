package com.chat;

import com.chat.auth.User;
import com.chat.auth.VerifyUser;
import com.chat.chatController.ChatManager;

public class ChatClient {

    // verify user
    
    public void Start() {
        VerifyUser verifyUser = new VerifyUser();
        User user = verifyUser.verify();
        ChatManager chatManager = new ChatManager(user);
        chatManager.start();
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.Start();
    }



    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Enter your username: ");
    //     String username = scanner.nextLine();

    //     MqttHandler mqtt = new MqttHandler(username);
    //     mqtt.connect();

    //     System.out.println("Welcome, " + username + "!");
    //     System.out.println("To send a message: /msg <recipient> <message>");

    //     while (true) {
    //         String input = scanner.nextLine();

    //         if (input.startsWith("/msg ")) {
    //             String[] parts = input.split(" ", 3);
    //             if (parts.length < 3) {
    //                 System.out.println("Invalid command. Usage: /msg <recipient> <message>");
    //                 continue;
    //             }

    //             String recipient = parts[1];
    //             String message = parts[2];

    //             mqtt.sendMessage(recipient, message);
    //         } else if (input.equalsIgnoreCase("/exit")) {
    //             mqtt.disconnect();
    //             System.out.println("Exiting...");
    //             break;
    //         } else {
    //             System.out.println("Unknown command.");
    //         }
    //     }
    //     scanner.close();
    // }
}
