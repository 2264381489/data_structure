package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/anno")
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了....");
        System.out.println(username);
        return "success";
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了....");
        System.out.println(body);
        return "success";
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(){
        System.out.println("执行了....");
//        System.out.println(body);
        return "success";
    }
    @ModelAttribute
    public void showUser(){
        System.out.println("show执行了//.......");
    }
}
