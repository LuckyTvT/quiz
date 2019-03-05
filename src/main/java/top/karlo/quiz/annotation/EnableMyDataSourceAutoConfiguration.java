package top.karlo.quiz.annotation;

import org.springframework.context.annotation.Import;
import top.karlo.quiz.config.MyImportSelector;

import java.lang.annotation.*;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/1 14:42
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import(MyImportSelector.class)
public @interface EnableMyDataSourceAutoConfiguration {

}
