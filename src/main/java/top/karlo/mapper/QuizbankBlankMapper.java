package top.karlo.mapper;

import java.util.List;
import top.karlo.quiz.pojo.QuizbankBlank;

public interface QuizbankBlankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuizbankBlank record);

    QuizbankBlank selectByPrimaryKey(Integer id);

    List<QuizbankBlank> selectAll();

    int updateByPrimaryKey(QuizbankBlank record);
}