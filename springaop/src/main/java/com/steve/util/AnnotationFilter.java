package com.steve.util;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Description: 自定义包扫描注解的过滤条件
 * @Author: HiWin10
 * @Date: 2020/2/1310:23
 **/
public class AnnotationFilter implements TypeFilter {

    /**
     * @Author  SteveTao
     * @Description TODO
     * @Date 2020/2/13 10:28
     * metadataReader:  读取当前正在扫描类的信息
     * metadataReaderFactory:   可以读取其他类的信息
     **/
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前扫描类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息（ 类路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("ScanClass IS : "+className);
        if(className.contains("Service")){
            return true;
        }
        return false;
    }
}
