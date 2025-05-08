package com.example.springtransactionaltest2.model;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public void displayMessage(String arg){
        System.out.println("**********************************");
        System.out.println(arg);
        System.out.println("**********************************");
    }
}
