package top.karlo.quiz.service.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.mapper.user.UserMapper;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.util.EncryptUtil;

import java.util.List;
import java.util.UUID;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/12/31 11:19
 * @since 1.0.0
 */

@Service
@Slf4j
//@Transactional(rollbackFor = Exception.class)
@DataSource("quizUser")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserByUsername(String username) {

        return userMapper.getUserByUsername(username);
    }


    @Override
    public void regist(User user) {
        String userUniqueSalt = generateSalt();
        String plainText = user.getPassword().concat(userUniqueSalt);
        String cipherText = EncryptUtil.getCipherText(plainText);
        user.setPassword(cipherText);
        user.setUniqueSalt(userUniqueSalt);
        userMapper.insert(user);

    }

    @Override
    public boolean checkUserhasExist(String username) {
        User user = userMapper.getUserByUsername(username);
        return user == null ? false : true;
    }


    private String generateSalt(){
        //使用随机的uuid作为salt
        return UUID.randomUUID().toString();
    }

}
