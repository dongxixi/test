package com.lovo.client.controller;

import com.lovo.client.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getUserList")
    public String getUserList() {
        UserEntity user = restTemplate.getForEntity("http://service/getUserList", UserEntity.class).getBody();

//        for (UserEntity user : list) {

        System.out.println(user.toString());
//        }
        return "1";
    }
}
