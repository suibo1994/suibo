package com.sy.feign;


import com.sy.sycommon.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(value = "SERVICE-HI")
public interface  HelloService
{

    @GetMapping("/hi?name=")
    User hiService(String name);
}
