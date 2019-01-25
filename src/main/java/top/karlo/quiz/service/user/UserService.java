package top.karlo.quiz.service.user;

import top.karlo.quiz.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询全部用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 注册
     * @param user
     */
    void regist(User user);

}
