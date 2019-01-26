package top.karlo.quiz.service.quiz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.karlo.quiz.annotation.DataSource;
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
@Transactional(rollbackFor = Exception.class)
@Slf4j
@DataSource
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizTypeMapper quizTypeMapper;

    @Override
    public List<QuizType> getAllType() {
        return quizTypeMapper.selectAll();
    }
}