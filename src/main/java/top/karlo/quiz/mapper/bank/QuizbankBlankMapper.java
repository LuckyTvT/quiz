package top.karlo.quiz.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.pojo.QuizbankBlank;

@Mapper
public interface QuizbankBlankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuizbankBlank record);

    QuizbankBlank selectByPrimaryKey(Integer id);

    List<QuizbankBlank> selectAll();

    int updateByPrimaryKey(QuizbankBlank record);
}