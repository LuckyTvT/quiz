package top.karlo.quiz.service.quiz;

import top.karlo.quiz.pojo.QuizType;

import java.util.List;

/**
 * 功能描述：
 *  题目类型service 主要负责对quiz_type表的维护
 * @author Karlo
 * @date 2018/12/28 12:39
 */
public interface QuizService {

    /**
     * 查询全部题目类型数据
     */
    List<QuizType> getAllType();


}
