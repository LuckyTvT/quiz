package top.karlo.quiz.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.pojo.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}