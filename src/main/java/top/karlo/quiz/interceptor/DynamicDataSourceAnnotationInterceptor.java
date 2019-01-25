package top.karlo.quiz.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.config.DynamicDataSourceContextHolder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/12/31 18:27
 * @since 1.0.0
 */

public class DynamicDataSourceAnnotationInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAnnotationInterceptor.class);


    /**
     * 缓存方法注解值
     */
    private static final Map<Method, String> METHOD_CACHE = new HashMap<>();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            String datasource = determineDatasource(invocation);
            logger.info("数据源：{}",datasource);
            if (! DynamicDataSourceContextHolder.containsDataSource(datasource)) {
                logger.info("数据源[{}]不存在，使用默认数据源 >", datasource);
            }
            DynamicDataSourceContextHolder.setDataSourceRouterKey(datasource);
            return invocation.proceed();
        } finally {
            DynamicDataSourceContextHolder.removeDataSourceRouterKey();
        }
    }

    private String determineDatasource(MethodInvocation invocation) {
        Method method = invocation.getMethod();
        if (METHOD_CACHE.containsKey(method)) {
            return METHOD_CACHE.get(method);
        } else {
            DataSource ds = method.isAnnotationPresent(DataSource.class) ? method.getAnnotation(DataSource.class)
                    : AnnotationUtils.findAnnotation(method.getDeclaringClass(), DataSource.class);
            METHOD_CACHE.put(method, ds.value());
            return ds.value();
        }
    }


}
