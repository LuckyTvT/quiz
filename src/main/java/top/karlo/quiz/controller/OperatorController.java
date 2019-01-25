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
 *
 * @author Karlo
 * @date 2019/1/18 14:04
 */
@Controller
public class OperatorController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/regist")
    public void regist(User user){

        userService.regist(user);
    }


//    @PostMapping("/regist")
//    public void regist(User user){
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//    }


}