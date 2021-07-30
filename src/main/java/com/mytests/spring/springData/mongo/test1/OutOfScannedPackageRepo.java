package com.mytests.spring.springData.mongo.test1;

import com.mytests.spring.springData.mongo.test1.data.Shop;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: mongotest1
 * *******************************
 */
public interface OutOfScannedPackageRepo extends CrudRepository<Shop, BigInteger> {
    Stream<Shop> streamShopsBySellsContaining(String sells);
}
