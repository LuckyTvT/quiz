package top.karlo.quiz.config;

import org.springframework.context.annotation.Bean;
import top.karlo.quiz.aop.DynamicDataSourceAnnotationAdvisor;
import top.karlo.quiz.interceptor.DynamicDataSourceAnnotationInterceptor;

/**
 * 功能描述：
 *  用来对bean进行定义并装配
 * @author Karlo
 * @date 2019/3/1 14:38
 */

public class BeanConfig {

    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }

}
