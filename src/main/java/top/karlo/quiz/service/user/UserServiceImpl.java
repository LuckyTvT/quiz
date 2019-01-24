package top.karlo.quiz.service.user;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.karlo.quiz.mapper.user.UserMapper;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.util.EncryptUtil;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/12/31 11:19
 * @since 1.0.0
 */

@Service(value = "userService1")
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

        return userMapper.getUserByUsername(username);
    }

    @Override
    public void regist(String username, String password, String email, String telephone,
                       String image, String extra1,String extra2,String extra3) {
        String userUniqueSalt = generateSalt();
        String plainText = password.concat(userUniqueSalt);
        String cipherText = EncryptUtil.getCipherText(plainText);
        User user = new User();
        user.setUsername(username);
        //password要存储经过salt处理后的密文
        user.setPassword(cipherText);
        //将每个用户自己的加密salt存储进去
        user.setUniqueSalt(userUniqueSalt);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setImage(image);
        user.setExtra1(extra1);
        user.setExtra2(extra2);
        user.setExtra3(extra3);
        userMapper.insert(user);

    }


    private String generateSalt(){
        //使用随机的uuid作为salt
        return UUID.randomUUID().toString();
    }

}
