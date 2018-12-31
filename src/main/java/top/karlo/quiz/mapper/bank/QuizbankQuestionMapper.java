package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizbankQuestion;

@Mapper
public interface QuizbankQuestionMapper {

    @DataSource
    int deleteByPrimaryKey(Integer id);

    @DataSource
    int insert(QuizbankQuestion record);

    @DataSource
    QuizbankQuestion selectByPrimaryKey(Integer id);

    @DataSource
    List<QuizbankQuestion> selectAll();

    @DataSource
    int updateByPrimaryKey(QuizbankQuestion record);
}