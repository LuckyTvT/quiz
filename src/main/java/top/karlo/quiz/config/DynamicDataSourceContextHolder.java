package top.karlo.quiz.config;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/12/31 14:22
 * @since 1.0.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: karlo
 * @Date: 2018/12/31 14:23
 * @Description: 数据源上下文
 */
public class DynamicDataSourceContextHolder {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * 存储已经注册的数据源的key
     */
    public static List<String> dataSourceIds = new ArrayList<>();

    /**
     * 线程级别的私有变量
     */
    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static String getDataSourceRouterKey () {
        return HOLDER.get();
    }

    public static void setDataSourceRouterKey (String dataSourceRouterKey) {
        logger.info("切换至{}数据源", dataSourceRouterKey);
        HOLDER.set(dataSourceRouterKey);
    }

    /**
     * 设置数据源之前一定要先移除
     */
    public static void removeDataSourceRouterKey () {
        HOLDER.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     *
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}