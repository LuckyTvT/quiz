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
        System.out.println("blank");
        return "quiz/blank";
    }

    @RequestMapping("/choice")
    public String jumpToChoice(){
        System.out.println("choice");
        return "quiz/choice.html";
    }

    @RequestMapping("/shortAns")
    public String jumpToShortAns(){
        System.out.println("shortAns");
        return "quiz/shortAns.html";
    }
}

