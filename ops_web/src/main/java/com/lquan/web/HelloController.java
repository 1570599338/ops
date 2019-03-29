package com.lquan.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName HelloController
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String index(){

        return "hello world !";
    }
}
