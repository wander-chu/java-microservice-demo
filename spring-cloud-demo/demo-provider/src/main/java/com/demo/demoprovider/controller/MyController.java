package com.demo.demoprovider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getDefaultInfo() {
        try {
            //休眠2秒，测试超时服务熔断[直接关闭服务提供者亦可]
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello provider";
    }

    @RequestMapping(value = "/info/{name}", method = RequestMethod.POST)
    public String getInfo(@PathVariable String name) {
        return "Hello " + name;
    }

}
