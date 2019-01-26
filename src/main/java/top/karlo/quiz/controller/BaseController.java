package top.karlo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.karlo.quiz.pojo.QuizType;
import top.karlo.quiz.service.quiz.QuizService;
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
    UserService userService;





}
