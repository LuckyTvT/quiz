package top.karlo.quiz.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.karlo.quiz.mapper.bank.QuizTypeMapper;
import top.karlo.quiz.pojo.QuizType;

import java.util.List;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2018/12/28 12:42
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private QuizTypeMapper quizTypeMapper;

    @Override
    public List<QuizType> getAllType() {
        return quizTypeMapper.selectAll();
    }
}
