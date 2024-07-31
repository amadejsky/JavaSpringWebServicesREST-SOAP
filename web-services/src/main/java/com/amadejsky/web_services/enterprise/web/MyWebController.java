package com.amadejsky.web_services.enterprise.web;

import com.amadejsky.web_services.enterprise.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    @Autowired
    private BusinessService businessService;

    public long returnValueFromBusinessService() {
        System.out.println("--Business system response from Server--");
        System.out.println("----------------------------------------");
        return businessService.calculate();

    }
}
