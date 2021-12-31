package com.yusael.travels.controller;

import com.yusael.travels.entity.Result;
import com.yusael.travels.entity.User;
import com.yusael.travels.service.UserService;
import com.yusael.travels.utils.CreateImageCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin // 允许跨域(前后端分离)
@Slf4j // 日志对象
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
//    @PostMapping("/login")
    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        log.info("接收的user对象：" + user);
        Result result = new Result();
        try {

                User userDB = userService.login(user);
                // 登录成功之后保存用户的标记 ServletContext application Redis userid userdb
                request.getServletContext().setAttribute(userDB.getId(), userDB);
                result.setMsg("登录成功!!!").setUserId(userDB.getId());
        } catch (Exception e) {
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
//    @PostMapping("/register")
    @RequestMapping("/register")
    public Result register(@RequestBody User user, HttpServletRequest request) { // axios发送的是JSON数据, 需要加@RequestBody来接收
        log.info("接收的user对象：" + user);
        Result result = new Result();
        try {
                userService.register(user);
                result.setMsg("注册成功!!!");

        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }



}
