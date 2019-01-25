package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizType;

@Mapper
public interface QuizTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(QuizType record);

    QuizType selectByPrimaryKey(Integer id);

    List<QuizType> selectAll();

    int updateByPrimaryKey(QuizType record);
}