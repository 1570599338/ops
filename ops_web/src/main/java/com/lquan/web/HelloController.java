package com.lquan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.dao.SysUserMapper;
import com.lquan.ops.model.back.po.SysUser;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class HelloController {
    @Autowired
    private SysUserMapper service;

    @RequestMapping("/hello")
    public  String index(){

        return "hello world !";
    }
    
    @RequestMapping("/hello2")
    public  String index2(){
    	SysUser user = service.selectByPrimaryKey(2);

        return user.getNickname();
    }
}
