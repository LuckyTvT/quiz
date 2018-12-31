package top.karlo.quiz.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2018/12/30 17:00
 */
@Configuration
//@MapperScan(basePackages = {"top.karlo.mapper.user"},sqlSessionTemplateRef = "quizUserSqlSessionTemplate")
public class QuizUserDataSourceConfig {


    /**
     * 必须加此注解，不然报错，下一个类则不需要添加
     * @return
     */
    @Bean(name="quizUserDataSource")
    // prefix值必须是application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix="spring.datasource.quizuser")
    public DataSource quizUserDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="quizUserSqlSessionFactory")
    public SqlSessionFactory quizUserSqlSessionFactory(@Qualifier("quizUserDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        //添加xml目录
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:top/karlo/quiz/mapper/user/*.xml"));
        return sqlSessionFactory.getObject();
    }



    @Bean(name="quizUserSqlSessionTemplate")
    public SqlSessionTemplate quizBankSessionTemplate(@Qualifier("quizUserSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        // 使用上面配置的Factory
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "quizUserTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("quizUserDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
