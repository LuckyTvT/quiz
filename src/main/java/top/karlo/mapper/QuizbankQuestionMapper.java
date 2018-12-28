package top.karlo.mapper;

import java.util.List;
import top.karlo.quiz.pojo.QuizbankQuestion;

public interface QuizbankQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuizbankQuestion record);

    QuizbankQuestion selectByPrimaryKey(Integer id);

    List<QuizbankQuestion> selectAll();

    int updateByPrimaryKey(QuizbankQuestion record);
}