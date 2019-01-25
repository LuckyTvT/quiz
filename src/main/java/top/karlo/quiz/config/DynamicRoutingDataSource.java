package top.karlo.quiz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 功能描述:
 *      动态数据源路由
 * @author karlo
 * @date 2018/12/31 14:23
 * @since 1.0.0
 */

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private static Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
        logger.info("当前数据源是：{}", dataSourceName);
        return dataSourceName;
    }
}
