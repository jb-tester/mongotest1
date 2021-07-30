package com.mytests.spring.springData.mongo.test1;

import com.mytests.spring.springData.mongo.test1.configs.MyConfig;
import com.mytests.spring.springData.mongo.test1.services.ShopService;
import com.mytests.spring.springData.mongo.test1.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/12/2017.
 * Project: mongotest1
 * *******************************
 */
public class RunMe {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.findAllUsers();
        System.out.println("------------------------------");
        userService.findUsersByNames("irina","petrovskaya");
        System.out.println("------------------------------");
        userService.findOldUsers(30);
        System.out.println("------------------------------");
        userService.findUsersByName("irina");
        System.out.println("!!!!!!!!------------------------------");
        userService.aggregations();
        System.out.println("!!!!!!!!------------------------------");
        userService.extra();
        System.out.println("------------------------------");
        userService.foo();
        System.out.println("------------------------------");
        userService.testNested(40);
        System.out.println("------------------------------");
        userService.findUsersByCity("SPb");

        System.out.println("=================================");
        ShopService shopService = ctx.getBean(ShopService.class);
        shopService.checkNearPoint();
        System.out.println("------------------------------");
        shopService.findAllCellingFood();
    }

}