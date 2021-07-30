package com.mytests.spring.springData.mongo.test1.repositories;

import com.mytests.spring.springData.mongo.test1.OutOfScannedPackageRepo;
import com.mytests.spring.springData.mongo.test1.data.Shop;
import org.springframework.data.geo.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
public interface ShopsRepository extends CrudRepository<Shop, BigInteger>, OutOfScannedPackageRepo {

    List<Shop> findByLocationNear(Point location, double min, double max);

    GeoResults<Shop> findByLocationNear(Point p, Distance oneKilometer);

    List<Shop> findByLocationWithin(Circle circle);

    List<Shop> findByLocationWithin(Box box);

    List<Shop> findByLocationWithin(Point p); // invalid!

    List<Shop> findByStoreLocationWithin(Circle store_location);

}
