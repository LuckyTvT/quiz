package top.karlo.quiz.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import top.karlo.quiz.pojo.User;
import top.karlo.quiz.util.EncryptUtil;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Collection;
import java.util.Objects;

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
            log.info("password ");
            throw new BadCredentialsException("密码错误");
        }
        Collection<? extends GrantedAuthority> collection = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, collection);
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
