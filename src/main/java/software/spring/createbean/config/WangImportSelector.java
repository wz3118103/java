package software.spring.createbean.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class WangImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"software.spring.createbean.bean.Fish",
                "software.spring.createbean.bean.Tiger"};
    }
}
