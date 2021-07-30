package com.mytests.spring.springData.mongo.test1.configs;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/12/2017.
 * Project: mongotest1
 * *******************************
 */
@Configuration
@ComponentScan(basePackages = "com.mytests.spring.springData.mongo.test1.services")
@EnableMongoRepositories(basePackages = "com.mytests.spring.springData.mongo.test1.repositories", mongoTemplateRef = "mongo_template", repositoryImplementationPostfix = "Impl", considerNestedRepositories = false)
public class MyConfig {

    public @Bean
    Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    public @Bean MongoTemplate mongo_template() throws Exception {
        return new MongoTemplate(mongo(), "mydb1");
    }

}
