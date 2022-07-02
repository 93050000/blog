package com.zhao.controller;

import com.zhao.mapper.UserMapper;
import com.zhao.pojo.User;
import com.zhao.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/toLogin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping("/Login")
    public String Login(String name, String password, Model model,HttpSession session){
        User user = userService.queryByName(name);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(password,user.getPassword());
        if (user == null || !matches){
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
        if (user.getValid() ==0){
            model.addAttribute("error","该用户已被禁用，请换一个账号登录");
            return "login";
        }
        model.addAttribute("user",user.getName());
        session.setAttribute("username",user.getUsername());
        return "forward:/";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        if (session.getAttribute("name")!=null){
            session.removeAttribute("name");
        }
        return "forward:/";
    }

    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user, Model model, HttpSession httpSession){
        User user1 = userService.queryByName(user.getName());
        User user2 = userService.queryByUsername(user.getUsername());
        if (user1 == null) {
        if (user2 ==null) {
          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encode = encoder.encode(user.getPassword());
            user.setPassword(encode);
            userService.insertUser(user);
            httpSession.setAttribute("name", user.getName());
            return "login";
        }else{
            model.addAttribute("error","用户名重复");
            return "register";
        }
        }else{
            model.addAttribute("error","账号已存在");
            return "register";
        }
    }


}
