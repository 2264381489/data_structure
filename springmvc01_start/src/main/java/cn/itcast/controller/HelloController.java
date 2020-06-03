package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {
@RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello StringMvc");
        return "success";
    }
    @RequestMapping(path = "/testRequestMapping",params = {"username=hehe"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("ceshi");
        return "success";
    }


}
