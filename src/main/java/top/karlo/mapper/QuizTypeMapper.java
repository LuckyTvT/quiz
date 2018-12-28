package top.karlo.mapper;

import java.util.List;
import top.karlo.quiz.pojo.QuizType;

public interface QuizTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuizType record);

    QuizType selectByPrimaryKey(Integer id);

    List<QuizType> selectAll();

    int updateByPrimaryKey(QuizType record);
}