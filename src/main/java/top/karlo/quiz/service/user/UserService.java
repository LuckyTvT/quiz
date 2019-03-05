package top.karlo.quiz.service.user;

import top.karlo.quiz.pojo.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 校验该用户名是否已存在
     * @param username
     * @return
     */
    boolean checkUserhasExist(String username);

    void updateUserInfo(Map<String, Object> map);
}
