package top.karlo.quiz.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.service.user.UserService;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/1/6 13:44
 * @since 1.0.0
 */

@Component
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        return user;
    }
}
