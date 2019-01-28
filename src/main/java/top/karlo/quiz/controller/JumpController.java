package top.karlo.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述：
 *  专门用来做跳转用的controller
 * @author Karlo
 * @date 2019/1/28 10:39
 */
@Controller
public class JumpController {

    @RequestMapping("/blank")
    public String jumpToBlank(){
        return "quiz/blank";
    }

    @RequestMapping("/choice")
    public String jumpToChoice(){
        return "quiz/choice.html";
    }

    @RequestMapping("/shortAns")
    public String jumpToShortAns(){
        return "quiz/shortAns.html";
    }

    @RequestMapping("/userAuthorize")
    public String jumpToUserAuthorize(){
        return "user/userAuthorize.html";
    }

    @RequestMapping("/userManage")
    public String jumpToUserManage(){
        return "user/userManage.html";
    }

}

