package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizbankQuestion;

@Mapper
public interface QuizbankQuestionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(QuizbankQuestion record);

    QuizbankQuestion selectByPrimaryKey(Integer id);

    List<QuizbankQuestion> selectAll();

    int updateByPrimaryKey(QuizbankQuestion record);
}