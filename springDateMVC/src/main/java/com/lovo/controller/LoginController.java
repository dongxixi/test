package com.lovo.controller;

import com.lovo.entity.User;
import com.lovo.entity.UserInfo;
import com.lovo.service.UserInfoService;
import com.lovo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {

    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;

    @RequestMapping("login.do")
    @ResponseBody
    public List<UserInfo> login(String name, String password) {
//        ModelAndView mv = new ModelAndView();
        User user = userService.findByNameAndPassword(name, password);
        if (user == null) {
            return null;
        }
        List<UserInfo> userInfoList = userInfoService.getUserInfoByUserId(user.getId());
//        for (UserInfo userInfo : userInfoList) {
//            System.out.println(userInfo.getSalary());
//        }
//        mv.setViewName("show");
        return userInfoList;
    }

    @RequestMapping("redirect.do")
    public ModelAndView redirect() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("redirect:https://www.baidu.com");

        return mv;
    }

    @RequestMapping("forward.do")
    public ModelAndView forward() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("forward:WEB-INF/jsp/show.jsp");

        return mv;
    }

    @RequestMapping("register.do")
    public ModelAndView upload(@RequestParam("multipartFile") MultipartFile multipartFile, String userName, String password) {
        String fileName = multipartFile.getOriginalFilename();

        String suffix = fileName.substring(fileName.lastIndexOf("."));

        UUID uuid = UUID.randomUUID();


        File file = new File("D:/upload/"+ uuid + suffix);

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setName(userName);
        user.setPassword(password);

        boolean flag = userService.addUser(user);

        ModelAndView mv = new ModelAndView();
        if (flag) {
            mv.addObject("msg", userName + "：注册成功");
            mv.addObject("img", uuid + suffix);
        } else {
            mv.addObject("msg", userName + "：注册失败");
        }
            mv.setViewName("forward:WEB-INF/jsp/show.jsp");

        return mv;
    }
}
