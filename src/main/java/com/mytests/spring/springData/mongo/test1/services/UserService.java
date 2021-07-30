package com.mytests.spring.springData.mongo.test1.services;

import com.mytests.spring.springData.mongo.test1.data.Address;
import com.mytests.spring.springData.mongo.test1.data.Summary;
import com.mytests.spring.springData.mongo.test1.data.User;
import com.mytests.spring.springData.mongo.test1.repositories.MyRepositories;
import com.mytests.spring.springData.mongo.test1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/12/2017.
 * Project: mongotest1
 * *******************************
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired(required = false)
    private MyRepositories.NestedUserRepository nestedRepository;

    @Autowired
    private MongoOperations mongoOperations;


    public void findAllUsers(){
        setUp();
        Iterable<User> users = repository.findAll();
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }
    public void findUsersByNames(String firstname, String lastname){
        setUp();
        List<User> users = repository.findByFirstnameAndLastname(firstname,lastname);
        for (User next : users) {
            System.out.println(next.toString());
        }
    }
    public void findOldUsers(int age){
        setUp();
        List<User> users = repository.findByAgeAfter(age);
        for (User next : users) {
            System.out.println(next.toString());
        }
    }

    public void findUsersByName(String name){
        setUp();
        List<User> users = repository.fooQuery(name);
        for (User next : users) {
            System.out.println(next.toString());
        }
    }
    public void findUsersByCity(String city){
        setUp();
        List<User> users = repository.findByAddressCity(city);
        for (User next : users) {
            System.out.println(next.toString());
        }
    }
    public void extra(){
        setUp();
        List<User> users = repository.extraFind();
        for (User next : users) {
            System.out.println(next.toString());
        }}

    public void aggregations(){
        setUp();
        User user = new User("masha","blinova", 10);

        repository.save(user);
        Summary summary = repository.getSummaryFor(user);

        System.out.println(summary.toString());

    }

    public void foo(){
        setUp();
        System.out.println(repository.countAllByAgeBetween(18,50));
    }

    public void testNested(int age) {
        if (nestedRepository == null) {
            System.out.println("nested repositories are not enabled!");
        }else{
        System.out.println(nestedRepository.findFirstByAgeAfter(age));}
    }

    ;
    private void setUp() {
        repository.deleteAll();
        Address a1 = new Address("Russia","SPb","Gavrskaya",15);
        Address a2 = new Address("Ukrain","Kharkiv","Selkorovsky",7);
        User u1 = new User("irina", "petrovskaya", 47);
        u1.setAddress(a1);
        repository.save(u1);
        User u2 = new User("vera", "ivanova", 21);
        u2.setAddress(a1);
        repository.save(u2);
        User u3 = new User("irina", "shevcova", 68);
        u3.setAddress(a2);
        repository.save(u3);

    }
}
