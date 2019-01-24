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
     * @param username
     * @param password
     * @param email
     * @param telephone
     * @param image
     * @param extra1
     * @param extra2
     * @param extra3
     */
    void regist(String username, String password, String email, String telephone,
                       String image, String extra1,String extra2,String extra3);

}
