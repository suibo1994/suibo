package com.sy.ribbon.controller;

import com.sy.ribbon.service.HelloService;
import com.sy.ribbon.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public User hi(@RequestParam String name)
    {
        return helloService.hiService(name);
    }

}
