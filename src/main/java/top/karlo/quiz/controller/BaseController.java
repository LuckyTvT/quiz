package top.karlo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.karlo.quiz.pojo.QuizType;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.service.type.TypeService;
import top.karlo.quiz.service.user.UserService;

import java.util.List;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2018/12/28 12:35
 */
@RestController
public class BaseController {

    @Autowired
    TypeService typeService;
    @Autowired
    UserService userService;

    /**
     * 录入题目类型数据
     * @return
     */
    @RequestMapping("/enterType")
    public String enteringQuizType(){
        return null;
    }

    @RequestMapping("/getAllType")
    public List<QuizType> getAllType(){
        return typeService.getAllType();
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    

}
