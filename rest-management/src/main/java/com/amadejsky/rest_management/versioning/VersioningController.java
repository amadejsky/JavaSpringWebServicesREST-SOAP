package com.amadejsky.rest_management.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersion(){
        return new PersonV1("Keanu Reaves");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersion(){
        return new PersonV2("Keanu","Reaves");
    }

    @GetMapping(path="/person", params = "version=1")
    public PersonV1 getFirstRequestVersion(){
        return new PersonV1("Keanu Reaves");
    }
    @GetMapping(path="/person", params = "version=2")
    public PersonV2 getSecondRequestVersion(){
        return new PersonV2("Keanu","Reaves");
    }
//    @GetMapping(path="/person/header", headers = "X-API-VERSION=1")
//    public PersonV1 getFirstVRequestVersion(){
//        return new PersonV1("Keanu Reaves");
//    }
//    @GetMapping(path="/person/header", headers = "X-API-VERSION=2")
//    public PersonV2 getSecondVRequestVersion(){
//        return new PersonV2("Keanu","Reaves");
//    }
        @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVRequestVersion(){
        return new PersonV1("Keanu Reaves");
    }
    @GetMapping(path="/person/accept", headers = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVRequestVersion(){
        return new PersonV2("Keanu","Reaves");
    }

}
