package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.QuizbankChoice;

@Mapper
public interface QuizbankChoiceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(QuizbankChoice record);

    QuizbankChoice selectByPrimaryKey(Integer id);

    List<QuizbankChoice> selectAll();

    int updateByPrimaryKey(QuizbankChoice record);
}