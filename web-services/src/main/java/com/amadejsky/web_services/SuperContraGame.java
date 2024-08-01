package com.amadejsky.web_services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContraGame implements GamingConsole{

    public void up(){
        System.out.println(" -SP- Up!");
    }
    public void down(){
        System.out.println(" -SP- Fire!");
    }
    public void left(){
        System.out.println(" -SP- Gone left!");
    }
    public void right(){
        System.out.println(" -SP- Gone right!");
    }
}
