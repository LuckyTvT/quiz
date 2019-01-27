package top.karlo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.karlo.quiz.pojo.QuizType;
import top.karlo.quiz.pojo.QuizbankBlank;
import top.karlo.quiz.pojo.QuizbankChoice;
import top.karlo.quiz.pojo.QuizbankQuestion;
import top.karlo.quiz.service.quiz.QuizService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String enteringQuizType(QuizType type){
        return null;
    }

    /**
     * 录入填空题
     */
    @PostMapping("/enteringBlank")
    public Map<String,Object> enteringQuizBlank(QuizbankBlank blank){
        boolean enteringBlank = quizService.enteringBlank(blank);
        return buildInsertResult(enteringBlank);
    }


    /**
     * 录入选择题
     */
    @PostMapping("/enteringChoice")
    public Map<String,Object> enteringChoice(QuizbankChoice choice){
        boolean enteringChoice = quizService.enteringChoice(choice);
        return buildInsertResult(enteringChoice);
    }

    /**
     * 录入简答题
     */
    @PostMapping("/enteringShortAns")
    public Map<String,Object> enteringShortAnswer(QuizbankQuestion shortAns){
        boolean enteringShortAns = quizService.enteringShortAns(shortAns);
        return buildInsertResult(enteringShortAns);
    }

    /**
     * 统一处理插入方法的返回结果
     * @param enteringBlank
     * @return
     */
    private Map<String,Object> buildInsertResult(Object enteringBlank) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("insertResult",enteringBlank);
        return resultMap;
    }

}
