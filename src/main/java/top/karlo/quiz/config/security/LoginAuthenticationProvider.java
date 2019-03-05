package top.karlo.quiz.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import top.karlo.quiz.mapper.user.UserMapper;
import top.karlo.quiz.pojo.QuizbankQuestion;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.service.user.UserService;
import top.karlo.quiz.util.EncryptUtil;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/1/6 13:22
 * @since 1.0.0
 */

@Component
@Slf4j
public class LoginAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        log.info("username:{},password:{}", username, password);
        final User user = (User) userDetailService.loadUserByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("用户不存在");
        }
        if (!checkUserPassword(user, password)) {
            log.info("password {}",password);
            throw new BadCredentialsException("密码错误");
        }
        //更新最后登录ip和时间
        SecurityContextHolder.getContext().setAuthentication(authentication);
        updateTimeandIP(user);
        Collection<? extends GrantedAuthority> collection = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, collection);
    }

    private void updateTimeandIP(User user) {
        //获取认证后的用户信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails wAuth = (WebAuthenticationDetails)auth.getDetails();
        String ip = wAuth.getRemoteAddress();
        Map<String, Object> map = new HashMap<>();
        map.put("ip",ip);
        map.put("lastTime",new Date());
        map.put("username",user.getUsername());
        userService.updateUserInfo(map);
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private static boolean checkUserPassword(User user, String formPassword) {
        final String operatorUniqueSalt = user.getUniqueSalt();
        final String plainPassword = formPassword.concat(operatorUniqueSalt);
        final String cipherText = EncryptUtil.getCipherText(plainPassword);
        final String password = user.getPassword();
        boolean userPassResult = Objects.equals(cipherText, password);
        log.info("userPassWord check result:{}",userPassResult);
        return userPassResult;
    }

}
