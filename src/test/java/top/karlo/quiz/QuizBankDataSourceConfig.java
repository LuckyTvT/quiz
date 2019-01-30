package top.karlo.quiz;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2018/12/30 13:46
 */
//@Configuration
//@MapperScan(basePackages = {"top.karlo.mapper.bank"},sqlSessionTemplateRef = "quizBankSqlSessionTemplate")
public class QuizBankDataSourceConfig {



    /**
     * 必须加此注解，不然报错，下一个类则不需要添加
     * @return
     */
    @Bean(name="quizBankDataSource")
    // prefix值必须是application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix="spring.datasource.quizbank")
    @Primary
    public DataSource quizBankDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="quizBankSqlSessionFactory")
    @Primary
    public SqlSessionFactory quizBankSqlSessionFactory(@Qualifier("quizBankDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        //添加xml目录
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:top/karlo/quiz/mapper/bank/*.xml"));
        return sqlSessionFactory.getObject();
    }



    @Bean(name="quizBankSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate quizBankSessionTemplate(@Qualifier("quizBankSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        // 使用上面配置的Factory
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "quizBankTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("quizBankDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
