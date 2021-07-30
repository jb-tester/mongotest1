package com.mytests.spring.springData.mongo.test1.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/12/2017.
 * Project: mongotest1
 * *******************************
 */
@Document(collection = "users")
public class User {
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    public User(String firstname, String lastname, int age) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Id
    BigInteger id;
    String firstname;
    String lastname;
    int age;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: " +
                "address=" + address.toString() +
                ", id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ' ';
    }
}


