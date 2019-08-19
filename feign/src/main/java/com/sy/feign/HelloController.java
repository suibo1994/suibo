package com.sy.feign;

import com.sy.sycommon.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi222")
    public User hi()
    {
        return helloService.hiService("22");
    }

}
