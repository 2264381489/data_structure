package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//请求参数绑定
@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了"+username+"面吗"+password);
        return "success";
    }
    @RequestMapping("/saveAccount")
    public String testParam(Account account){
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }
    @RequestMapping("/saveUser")
    public String saveUser(User account){
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }

}
