package com.amadejsky.web_services;

import org.springframework.stereotype.Component;

//@Component
public class MarioGame implements GamingConsole{

    public void up(){
        System.out.println("Up!");
    }
    public void down(){
        System.out.println("Crouched!");
    }
    public void left(){
        System.out.println("Gone left!");
    }
    public void right(){
        System.out.println("Gone right!");
    }
}
