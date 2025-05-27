package com.chat.auth;

import java.util.Scanner;

public class Register {
    public User addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter EmailId: ");
        String EmailId = scanner.nextLine();
        System.out.println("Enter UserName: ");
        String UserName = scanner.nextLine();
        System.out.println("Enter Password(min 4 letters): ");
        String Password = scanner.nextLine();
        System.out.println("Confirm your Password: ");
        String rePassword = scanner.nextLine();
        if(rePassword.equals(Password)){
            // this.register()
            return new User(UserName, EmailId);
        } else {
            System.out.println("password doesn't matched!!");
            return new User();
        }
    }

    private boolean register() {
        // yet to implement
        return true;
    }
}
