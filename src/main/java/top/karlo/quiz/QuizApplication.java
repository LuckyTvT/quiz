package top.karlo.quiz;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import top.karlo.quiz.aop.DynamicDataSourceAnnotationAdvisor;
import top.karlo.quiz.config.DynamicDataSource;
import top.karlo.quiz.interceptor.DynamicDataSourceAnnotationInterceptor;


/**
 * author:karlo
 * 图形文字地址：http://patorjk.com/software/taag/#p=display&f=Slant&t=KARLO
 */

@SpringBootApplication
@Import({DynamicDataSource.class})
public class QuizApplication {
    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

}

