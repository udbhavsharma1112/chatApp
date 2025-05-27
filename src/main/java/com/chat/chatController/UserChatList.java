package com.chat.chatController;
import java.util.ArrayList;
import java.util.List;
import com.chat.auth.User;

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
            if(user.getEmail().equals(Email)){
                this.selectedUser = user;
                history.printChatHistory();
                return true;
            }
        }
        // this.selectedUser = new User("utkarsh", "utkarsh@example.com");
        return false;
    }

    private void printUserChatList(List<User> list) {
        System.out.println("User Chat List:");
        for (User user : list) {
            System.out.println(" - " + user.getUserName() + " (" + user.getEmail() + ")");
        }
    }
    private List<User> getUserChatList(User user) {
        //fetchUser;
        List<User> userList = new ArrayList<>();
        userList.add(new User("utkarsh", "utkarsh@example.com"));
        userList.add(new User("udbhavsharma", "udbhavsharma@example.com"));
        printUserChatList(userList);
        return userList;
    }
}
