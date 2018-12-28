package top.karlo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.karlo.quiz.pojo.QuizType;
import top.karlo.quiz.service.type.TypeService;

import java.util.List;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2018/12/28 12:35
 */
@RestController
public class BaseAction {

    @Autowired
    TypeService typeService;

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





}
