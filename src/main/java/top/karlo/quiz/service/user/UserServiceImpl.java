package top.karlo.quiz.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.karlo.quiz.mapper.user.UserMapper;
import top.karlo.quiz.pojo.User;

import java.util.List;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/12/31 11:19
 * @since 1.0.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}
