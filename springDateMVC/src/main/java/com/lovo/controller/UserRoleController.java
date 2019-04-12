package com.lovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRoleController {

    @RequestMapping("userRole.do")
    public ModelAndView userRole() {
        ModelAndView mv = new ModelAndView();



        return mv;
    }
}
