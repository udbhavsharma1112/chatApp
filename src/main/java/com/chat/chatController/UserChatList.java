package com.chat.chatController;
import java.util.ArrayList;
import java.util.List;

import com.chat.api.UserChatInfo;
import com.chat.auth.User;
import com.chat.model.MessagePacket;

public class UserChatList {
    private User user;
    private User selectedUser;
    private List<User> userList;
    private ChatHistory history; 
    
    public UserChatList(User user) {
        this.user = user;
        history = new ChatHistory(user);
        this.userList = this.getUserChatList(this.user); 
    }

    public User getSelectedUser(){
        return this.selectedUser;
    }
    public boolean selectUser(String Email) {
        for (User user : this.userList) {
            if(user.getEmailId().equals(Email)){
                this.selectedUser = user;
                history.printChatHistory(selectedUser);
                return true;
            }
        }
        // this.selectedUser = new User("utkarsh", "utkarsh@example.com");
        return false;
    }
    

    private void printUserChatList(List<User> list) {
        System.out.println("User Chat List:"); 
        //want to print index as well
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println(" " + i + ". " + user.getUserName() + " (" + user.getEmailId() + ")");
        }
    }
    private List<User> getUserChatList(User user) {
        //fetchUser;
        UserChatInfo userChatInfo = new UserChatInfo();
        List<User> userList = userChatInfo.getChatList();
        this.printUserChatList(userList);
        return userList;
    }
}
