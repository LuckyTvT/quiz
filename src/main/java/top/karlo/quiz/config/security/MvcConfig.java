package top.karlo.quiz.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/1/2 17:08
 */
@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/regist").setViewName("regist");
        registry.addViewController("/regist1").setViewName("regist1");
        registry.addViewController("/greeting").setViewName("greeting");
        registry.addViewController("/all").setViewName("all");
    }

}
