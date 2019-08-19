package com.sy.custom;

import com.sy.sycommon.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomApplication.class, args);
    }
    @Value("${server.port}")
    String port;
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/hi")
    public User home(@RequestParam String name)
    {
        Map<String,Object> map =new HashMap<>();
        User user=userService.getUserById(1);
        String s= "hi " + name + ",i am from port:" + port;
        map.put("user",user);
        map.put("str",s);
        return user;
    }

}
