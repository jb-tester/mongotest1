package com.mytests.spring.springData.mongo.test1.repositories;

import com.mytests.spring.springData.mongo.test1.data.User;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
public class MyRepositories {

    public interface NestedUserRepository extends CrudRepository<User, BigInteger>{
        User findFirstByAgeAfter(int age);
    }
}
