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
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/regist").setViewName("regist");
        registry.addViewController("/greeting").setViewName("greeting");
        registry.addViewController("/all").setViewName("all");
        registry.addViewController("/test").setViewName("test");
    }

}
