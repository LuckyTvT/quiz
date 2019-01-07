package top.karlo.quiz.service.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
