package top.karlo.quiz.service.quiz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.mapper.bank.QuizTypeMapper;
import top.karlo.quiz.mapper.bank.QuizbankBlankMapper;
import top.karlo.quiz.mapper.bank.QuizbankChoiceMapper;
import top.karlo.quiz.mapper.bank.QuizbankQuestionMapper;
import top.karlo.quiz.pojo.QuizType;
import top.karlo.quiz.pojo.QuizbankBlank;
import top.karlo.quiz.pojo.QuizbankChoice;
import top.karlo.quiz.pojo.QuizbankQuestion;

import java.util.Date;
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
    @Autowired
    private QuizbankBlankMapper blankMapper;
    @Autowired
    private QuizbankChoiceMapper choiceMapper;
    @Autowired
    private QuizbankQuestionMapper shortAnsMapper;

    @Override
    public List<QuizType> getAllType() {
        return quizTypeMapper.selectAll();
    }

    @Override
    public boolean enteringBlank(QuizbankBlank blank) {
        blank.setInTime(new Date());
        int insertLine = blankMapper.insert(blank);
        return insertLine == 1 ? true : false;
    }

    @Override
    public boolean enteringChoice(QuizbankChoice choice) {
        choice.setInTime(new Date());
        int insertLine = choiceMapper.insert(choice);
        return insertLine == 1 ? true : false;
    }

    @Override
    public boolean enteringShortAns(QuizbankQuestion shortAns) {
        shortAns.setInTime(new Date());
        int insertLine = shortAnsMapper.insert(shortAns);
        return insertLine == 1 ? true : false;
    }


}
