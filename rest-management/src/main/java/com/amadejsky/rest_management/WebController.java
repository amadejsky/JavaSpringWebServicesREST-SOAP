//package com.amadejsky.rest_management;
//import com.amadejsky.rest_management.models.beans.HelloWorldBean;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class WebController {
//
//    @GetMapping(path="/test")
//    public String helloWorld(){
//        return "Hello World --Test";
//    }
//
//    @GetMapping(path="/bean-test")
//    public HelloWorldBean beanTest(){
//        return new HelloWorldBean("Hello World! --Bean test");
//    }
//
//    @GetMapping(path="/bean-test/path-variable/{name}")
//    public HelloWorldBean patchVariableTest(@PathVariable String name){
//        return new HelloWorldBean("Hello"+" "+name+" "+"wellcome! --Path variable test");
//    }
//
//
//}
