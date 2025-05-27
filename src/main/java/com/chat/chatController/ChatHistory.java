package com.chat.chatController;
import java.util.ArrayList;
import java.util.List;

import com.chat.auth.User;

public class ChatHistory {
    private User user;
    public ChatHistory(User user) {
        this.user = user;
    }

    public List<IMessage> getChatHistory() {
        return new ArrayList<>();
    }

    public void printChatHistory() {
        System.out.println("Chat History for User: " + user.getUserName());
        this.getChatHistory();
    }

    public void saveChatMessage() {
        System.out.println("message Saved!!");
    }
}
