package com.mytests.spring.springData.mongo.test1.repositories;

import com.mytests.spring.springData.mongo.test1.data.Summary;
import com.mytests.spring.springData.mongo.test1.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/13/2017.
 * Project: mongotest1
 * *******************************
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final MongoOperations mongoOperations;

    @Autowired
    public UserRepositoryImpl( MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    @Override
    public List<User> extraFind() {


        return mongoOperations.find(new Query(), User.class, "users");
    }

    @Override
    public Summary getSummaryFor(User user) {
        TypedAggregation<User> agg = newAggregation(User.class,
                match(where("id").is(user.getId())),
                project("firstname","age")
                        .andExpression("firstname").as("name")
                        .andExpression("age" ).as("adult")


        );

        AggregationResults<Summary> result = mongoOperations.aggregate(agg,"users", Summary.class);
        return result.getUniqueMappedResult();
    }
}
