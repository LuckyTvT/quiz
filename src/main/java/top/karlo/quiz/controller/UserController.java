package top.karlo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.service.user.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String regist(User user){
        if(user == null){
            return "regist";
        }
        userService.regist(user);
        return "test";

    }

    /**
     * 校验用户名是否已存在
     * @param username
     * @return
     */
    @PostMapping("/signcheck")
    @ResponseBody
    public Map check(String username){
        boolean isExist = userService.checkUserhasExist(username);
        HashMap<String, Object> resutlMap = new HashMap<>();
        resutlMap.put("isExist",isExist);
        return resutlMap;
    }



}
