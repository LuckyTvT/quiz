package top.karlo.mapper;

import java.util.List;
import top.karlo.quiz.pojo.QuizbankChoice;

public interface QuizbankChoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuizbankChoice record);

    QuizbankChoice selectByPrimaryKey(Integer id);

    List<QuizbankChoice> selectAll();

    int updateByPrimaryKey(QuizbankChoice record);
}