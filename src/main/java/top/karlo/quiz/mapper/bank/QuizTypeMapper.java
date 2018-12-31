package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizType;

@Mapper
public interface QuizTypeMapper {

    @DataSource
    int deleteByPrimaryKey(Integer id);

    @DataSource
    int insert(QuizType record);

    @DataSource
    QuizType selectByPrimaryKey(Integer id);

    @DataSource
    List<QuizType> selectAll();

    @DataSource
    int updateByPrimaryKey(QuizType record);
}