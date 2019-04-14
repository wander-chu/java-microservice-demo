package com.demo.democonsumer.controller;

import com.demo.democonsumer.client.InfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private InfoClient infoClient;

    @RequestMapping(value = "/call/info", method = RequestMethod.GET)
    public String consumerInfo(){
        return infoClient.getDefaultInfo();
    }

    @RequestMapping(value = "/call/info/{name}", method = RequestMethod.GET)
    public String consumerInfo(@PathVariable String name){
        return infoClient.getInfo(name);
    }
}
