package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizbankChoice;

@Mapper
public interface QuizbankChoiceMapper {

    @DataSource
    int deleteByPrimaryKey(Integer id);

    @DataSource
    int insert(QuizbankChoice record);

    @DataSource
    QuizbankChoice selectByPrimaryKey(Integer id);

    @DataSource
    List<QuizbankChoice> selectAll();

    @DataSource
    int updateByPrimaryKey(QuizbankChoice record);
}