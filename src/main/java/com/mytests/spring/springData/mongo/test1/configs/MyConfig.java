package com.mytests.spring.springData.mongo.test1.configs;



import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@EnableMongoRepositories(basePackages = "com.mytests.spring.springData.mongo.test1.repositories", mongoTemplateRef = "myMongoTemplate", repositoryImplementationPostfix = "Impl", considerNestedRepositories = false)
public class MyConfig {
    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/mydb1");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate myMongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mydb1");
    }

}
