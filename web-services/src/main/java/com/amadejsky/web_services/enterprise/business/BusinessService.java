package com.amadejsky.web_services.enterprise.business;

import com.amadejsky.web_services.enterprise.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessService{
    @Autowired
    private DataService dataService;
    public long calculate(){
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}
