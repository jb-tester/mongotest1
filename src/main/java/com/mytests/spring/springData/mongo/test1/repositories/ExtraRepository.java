package com.mytests.spring.springData.mongo.test1.repositories;

import com.mytests.spring.springData.mongo.test1.data.User;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/13/2017.
 * Project: mongotest1
 * *******************************
 */
public interface ExtraRepository {
    int countAllByAgeBetween(int age, int age2);

}
