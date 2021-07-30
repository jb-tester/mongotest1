package com.mytests.spring.springData.mongo.test1.repositories;

import com.mytests.spring.springData.mongo.test1.data.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/12/2017.
 * Project: mongotest1
 * *******************************
 */
public interface UserRepository extends CrudRepository<User,BigInteger>, UserRepositoryCustom, ExtraRepository {

    List<User> findByAgeAfter(int age);

    List<User> findByFirstnameAndLastname(String firstname, String lastname);

    @Query(value = "{ 'firstname' : ?0 }", fields = "{'firstname' :1, 'lastname' :1, 'age' :1, 'address' :1}")
    List<User> fooQuery(String name);

    List<User> findByAddressCity(String address_city);
}
