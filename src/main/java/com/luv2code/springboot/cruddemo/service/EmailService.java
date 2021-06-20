package com.luv2code.springboot.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.Mail;


@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void buyByMail(String email , String productname,int quantity  ){	
    	String body = productname + "  " + quantity ;
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mayanmohamed.vision@gmail.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(productname);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);

    }
    
    
    
    
    @Async
    public void sendMessageByMail(String email , int num  ){
    	
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mayanmohamed.vision@gmail.com");
        simpleMailMessage.setTo("mayanmohamed.vision@gmail.com");
        simpleMailMessage.setSubject("blah blah blah");
        simpleMailMessage.setText("blah blah blah");
        javaMailSender.send(simpleMailMessage);

    }
    
}