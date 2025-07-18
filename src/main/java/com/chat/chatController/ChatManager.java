package com.chat.chatController;
import java.util.Scanner;
import com.chat.auth.User;
import com.chat.model.MessagePacket;

public class ChatManager {
    Scanner scanner = new Scanner(System.in);

    private User user;
    private UserChatList chatList;
    private ChatSession chatSession;

    public ChatManager(User user) {
        this.user = user;
        chatList  = new UserChatList(user);
        chatSession = new ChatSession(this.user);
    }

    private boolean selectUser() {
        System.out.println("Enter the User Email Id to start Chat.");
        
        String EmailId = "";
        EmailId = scanner.nextLine();
        if(chatList.selectUser(EmailId)) {
            chatSession.setReceiverUser(chatList.getSelectedUser());
            return true;
        } else {
            System.out.println("No user found with email: " + EmailId);
            return this.selectUser();
        }
    }

   
    public void start() {
        if(this.selectUser()) {
            this.chatSession.subscribeToGeneralChat("user/" + user.getUserId()+ '/' + chatList.getSelectedUser().getUserId());
            this.chatSession.start();
        } else {
            System.out.println("❌ Unable to start chat session. Please try again.");
        }


    }
}
