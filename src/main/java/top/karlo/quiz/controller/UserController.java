package top.karlo.quiz.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.service.user.UserService;

import java.util.List;

/**
 * 功能描述：
 *      用户相关接口
 * @author Karlo
 * @date 2019/1/18 14:04
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    /**
     * 注册
     * @param user
     */
    @PostMapping("/signin")
    public void regist(User user){
        userService.regist(user);
    }



}
