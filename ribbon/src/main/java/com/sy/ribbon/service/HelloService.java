package com.sy.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService
{
    @Autowired
    RestTemplate restTemplate;

    public User hiService(String name)
    {
        ResponseEntity<User> forEntity= restTemplate.getForEntity("http://SERVICE-HI/hi?name=" + name, User.class);
        Object forObject=restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, Object.class);
    return forEntity.getBody();
    }
}
