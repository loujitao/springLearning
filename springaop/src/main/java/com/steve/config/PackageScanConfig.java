package com.steve.config;

import com.steve.util.AnnotationFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: HiWin10
 * @Date: 2020/2/1215:20
 **/
@Configuration
@ComponentScan(basePackages = "com.steve.bz",
//        excludeFilters = {   //排除某些类
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class)
//        },
        includeFilters = {  //只扫描某些类，要配置useDefaultFilters=false
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = AnnotationFilter.class)
        },useDefaultFilters=false
)
public class PackageScanConfig {
}
