package com.chat.auth;

import java.util.Scanner;

public class SignIn {
    Scanner scanner = new Scanner(System.in);
    public User verify(){
        System.out.println("Enter EmailId: ");
        String EmailId = scanner.nextLine();
        System.out.println("Enter UserName: ");
        String UserName = scanner.nextLine();
        System.out.println("Enter Password ");
        String Password = scanner.nextLine();
        boolean valid = validate(EmailId, Password);
        if(valid){
            // this.register()
            return new User(UserName, EmailId);
        } else {
            System.out.println("Invalid UserName or Password");
            return new User();
        }
    }
    private boolean validate(String Email, String Password) {
        return true;
    }
}
