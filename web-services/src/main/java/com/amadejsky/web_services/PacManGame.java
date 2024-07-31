package com.amadejsky.web_services;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{

    public void up(){
        System.out.println("-PC- Up!");
    }
    public void down(){
        System.out.println("-PC- Crouched!");
    }
    public void left(){
        System.out.println("-PC- Gone left!");
    }
    public void right(){
        System.out.println("-PC- Gone right!");
    }
}
