package top.karlo.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import top.karlo.quiz.aop.DynamicDataSourceAnnotationAdvisor;
import top.karlo.quiz.config.DynamicDataSource;
import top.karlo.quiz.interceptor.DynamicDataSourceAnnotationInterceptor;

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

