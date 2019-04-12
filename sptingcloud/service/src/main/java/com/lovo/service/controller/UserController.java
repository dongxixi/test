package com.lovo.service.controller;

import com.lovo.service.entity.UserEntity;
import com.lovo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("addUser.do")
    @ResponseBody
    public ModelAndView addUser(UserEntity userEntity) {
        ModelAndView mv = new ModelAndView();

        if (userService.addUser(userEntity) != null) {
            mv.addObject("user", userEntity);
            mv.setViewName("show");
        }

        List<UserEntity> list = userService.getUserList();

        mv.addObject("userList", list);

        return mv;
    }

    @RequestMapping("/")
    public String main() {
        return "test";
    }
}
