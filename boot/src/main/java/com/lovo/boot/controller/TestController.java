package com.lovo.boot.controller;

import com.lovo.boot.entity.UserEntity;
import com.lovo.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("add.do")
    public ModelAndView add(UserEntity userEntity) {
        ModelAndView mv = new ModelAndView();

        userService.addUser(userEntity);

        mv.addObject("user", userEntity);

        List<UserEntity> list = userService.getList();
        mv.addObject("list", list);

        mv.setViewName("show");


        return mv;
    }

    @RequestMapping("main")
    public String main() {
        return "test";
    }
}
