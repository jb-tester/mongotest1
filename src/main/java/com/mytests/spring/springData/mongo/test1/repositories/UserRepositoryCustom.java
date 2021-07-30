package com.mytests.spring.springData.mongo.test1.repositories;

import com.mytests.spring.springData.mongo.test1.data.User;
import com.mytests.spring.springData.mongo.test1.data.Summary;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/13/2017.
 * Project: mongotest1
 * *******************************
 */
public interface UserRepositoryCustom {

   List<User> extraFind();
   Summary getSummaryFor(User user);
}
