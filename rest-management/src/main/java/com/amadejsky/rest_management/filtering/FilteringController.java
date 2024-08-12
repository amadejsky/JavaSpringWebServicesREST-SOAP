package com.amadejsky.rest_management.filtering;

import com.amadejsky.rest_management.models.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        Example example = new Example("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(example);
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3","field6");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("ExampleFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
        List<Example> users = Arrays.asList(
                new Example("value1","value2","value3"),
                new Example("value4","value5","value6")
        ) ;
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3","field4","field6");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("ExampleFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;

    }
}
