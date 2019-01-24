package top.karlo.quiz.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 功能描述：
 *      security参见：https://www.jianshu.com/p/76bfa6743ba9
 *              https://blog.csdn.net/qq_35508033/article/details/79046441
 * @author Karlo
 * @date 2019/1/2 16:50
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;


//    private final UserDetailsService userDetailsService;


    /**
     * 配置user-detail服务 设置内存中默认用户
     * 这里需要注意的是，roles()方法是authorities()方法的简写形式。
     * roles()方法所给定的值都会加一个"ROLE_"前缀，并将其作为权限授予用户。实际上，如下用户配置与上面程序是一样的。
     * authorities("ROLE_AMIN","ROLE_USER")
     *
     * 除了上面的方法还有一些其它方法可以配置用户的详细信息。
     * accountExpired(boolean) 定义账号是否已经过期
     * accountLocked(boolean) 定义账号是否已经锁定
     * and() 用来连接配置
     * authorities(GrantedAuthority...) 授予某个用户一项或多项权限
     * authorities(List<? extends GrantedAuthority>) 授予某个用户一项或多项权限
     * authorities(String...) 授予某个用户一项或多项权限
     * credentialsExpired(boolean) 定义凭证是否已经过期
     * disabled(boolean) 定义账号是否已被禁用
     * password(String) 定义用户的密码
     * roles(String...) 授予某个用户一项或多项角色
     *

     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("user"))
                .roles("USER")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin123"))
                .roles("ADMIN","USER");

//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin123").roles("ADMIN","USER")
//                .and()
//                .withUser("user").password("user").roles("USER");
    }


    /**
     * configure(HttpSecurity http)方法定义了哪些URL路径应该被保护，哪些不应该被保护。
     * 其中“/”和“/home”路径被配置为不需要任何身份验证。其他所有其他路径都必须经过身份验证。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        UsernamePasswordAuthenticationFilter filter = new MyAuthenticatonFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
        filter.setAuthenticationSuccessHandler(new RedirectAuthenticationSuccessHandler("/"));

        http
                .csrf()
                .ignoringAntMatchers("/home/**")
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/", "/home")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
                .and()
                .addFilterAt(filter,MyAuthenticatonFilter.class)
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    @Override
    public void configure(WebSecurity web) throws Exception{
        //放行静态资源
        web.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/lib/**", "/captcha/**");
    }



}
