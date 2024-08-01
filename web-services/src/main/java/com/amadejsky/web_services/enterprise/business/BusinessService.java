package com.amadejsky.web_services.enterprise.business;

import com.amadejsky.web_services.enterprise.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessService{

    private DataService dataService;
    @Autowired
    public BusinessService(DataService dataService) {
        super();
        System.out.println("Constructor injection of DS in BS");
        this.dataService = dataService;
    }

//    @Autowired
//    public void setDataService(DataService dataService) {
//        System.out.println("BS Setter injection of DS");
//        this.dataService = dataService;
//    }

    public long calculate(){
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}
