package top.karlo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.karlo.quiz.pojo.QuizType;
import top.karlo.quiz.service.quiz.QuizService;

import java.util.List;

/**
 * 功能描述：
 *      题库相关接口
 * @author Karlo
 * @date 2019/1/26 14:06
 */
@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    /**
     * 查询全部题目类型类型 即quizType表
     * @return
     */
    @RequestMapping("/getAllType")
    public List<QuizType> getAllType(){
        return quizService.getAllType();
    }

    /**
     * 录入题目类型数据
     * @return
     */
    @RequestMapping("/enteringQuizType")
    public String enteringQuizType(){
        return null;
    }

    /**
     * 录入填空题
     */
    @PostMapping("/enteringBlank")
    public void enteringQuizBlank(){

    }

    /**
     * 录入选择题
     */
    @PostMapping("/enteringChoice")
    public void enteringChoice(){

    }

    /**
     * 录入简答题
     */
    @PostMapping("/enteringShortAns")
    public void enteringShortAnswer(){

    }

}