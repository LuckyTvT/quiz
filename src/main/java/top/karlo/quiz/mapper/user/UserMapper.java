package top.karlo.quiz.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.User;

@Mapper
public interface UserMapper {

    @DataSource("quizUser")
    int deleteByPrimaryKey(Integer id);

    @DataSource("quizUser")
    int insert(User record);

    @DataSource("quizUser")
    User selectByPrimaryKey(Integer id);

    @DataSource("quizUser")
    List<User> selectAll();

    @DataSource("quizUser")
    int updateByPrimaryKey(User record);
}