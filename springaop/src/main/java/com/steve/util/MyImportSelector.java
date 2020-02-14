package com.steve.util;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1315:19
 **/
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.steve.entity.Teacher"};
    }
}
