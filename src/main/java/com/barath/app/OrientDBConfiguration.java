package com.barath.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
//@EnableTransactionManagement
@EnableOrientRepositories(basePackages = "com.barath.app")
public class OrientDBConfiguration {

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory =  new OrientObjectDatabaseFactory();

        factory.setUrl("remote:localhost/testdb2");
        factory.setUsername("root");
        factory.setPassword("root");

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }


    @PostConstruct
    public void registerEntities() {
        factory().db().getEntityManager().registerEntityClass(Employee.class);
    }
}
