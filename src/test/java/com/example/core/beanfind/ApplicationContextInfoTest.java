package com.example.core.beanfind;

import com.example.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("display all beans")
    void findAllBean(){
        String []beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames
             ) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + beanDefinitionName + " object = " + bean);
        }
    }


    @Test
    @DisplayName("display application beans")
    void findApplicationBean(){
        String []beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
