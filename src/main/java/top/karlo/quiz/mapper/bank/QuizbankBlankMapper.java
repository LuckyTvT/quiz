package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizbankBlank;

@Mapper
public interface QuizbankBlankMapper {

    @DataSource
    int deleteByPrimaryKey(Integer id);

    @DataSource
    int insert(QuizbankBlank record);

    @DataSource
    QuizbankBlank selectByPrimaryKey(Integer id);

    @DataSource
    List<QuizbankBlank> selectAll();

    @DataSource
    int updateByPrimaryKey(QuizbankBlank record);
}