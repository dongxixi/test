package com.lovo.interceptor;

import com.lovo.entity.Role;
import com.lovo.entity.User;
import com.lovo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserRoleInterceptor implements HandlerInterceptor {

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");


        User findUser = userService.findByNameAndPassword(userName, password);

        User findRole = userService.findByRoleName(userName, password, roleName);

        if (findUser == null) {
            request.setAttribute("msg", "密码错误");
        } else if (findRole == null) {
            request.setAttribute("msg", "角色选择错误");
        } else {
            return true;
        }
            request.getRequestDispatcher("WEB-INF/jsp/user.jsp").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
