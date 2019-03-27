package top.karlo.quiz.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/1 14:47
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{BeanConfig.class.getName(),DynamicDataSource.class.getName()};
    }
}
