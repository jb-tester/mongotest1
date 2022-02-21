package com.mytests.spring.springData.mongo.test1.services;

import com.mytests.spring.springData.mongo.test1.OutOfScannedPackageRepo;
import com.mytests.spring.springData.mongo.test1.data.Shop;
import com.mytests.spring.springData.mongo.test1.data.Store;
import com.mytests.spring.springData.mongo.test1.repositories.ShopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
@Service
public class ShopService {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    MongoOperations operations;

    @Autowired
    private OutOfScannedPackageRepo shopsRepository;


    private void setUp(){
        GeospatialIndex indexDefinition = new GeospatialIndex("location");
        indexDefinition.getIndexOptions().put("min", -180);
        indexDefinition.getIndexOptions().put("max", 180);

        operations.indexOps(Shop.class).ensureIndex(indexDefinition);
        repository.deleteAll();
        Store store1 = new Store(new Point(200,200),1000);
        Store store2 = new Store(new Point(1,1),2000);
        Store store3 = new Store(new Point(300,300),3000);
        Shop shop1 = new Shop("Perekrestok","food", new Point(15,15),store1);
        Shop shop2 = new Shop("Pjaterochka","food", new Point(16,16), store3);
        Shop shop3 = new Shop("Aldo","shoes", new Point(130,130), store2);
        repository.save(shop1);
        repository.save(shop2);
        repository.save(shop3);
        List<Shop> shops = (List<Shop>) repository.findAll();
        System.out.println("shops created:");
        for (Shop next : shops) {
            System.out.println(next.toString());
        }
        System.out.println("---------------");
    }

    public void findAllCellingFood(){
        setUp();
        System.out.println("------ all food stores: ------");
        Stream<Shop> foodStores = shopsRepository.streamShopsBySellsContaining("food");
        for (Iterator<Shop> iterator = foodStores.iterator(); iterator.hasNext(); ) {
            Shop next = iterator.next();
            System.out.println(next.toString());
        }
    }

    public void findLargeStores(){
        setUp();
        System.out.println("------large shops:-----");
        List<Shop> result = repository.findByStoreSizeGreaterThan(1000);
        for (Shop shop : result) {
            System.out.println(shop);
        }
    }
    public void checkNearPoint(){
        setUp();
        System.out.println("----- check shops near points ----");
        Point p = new Point(0,0);
        Distance oneKilometer = new Distance(20, Metrics.KILOMETERS);
        Circle circle = new Circle(14,14,3);
        Circle circle2 = new Circle(0,0,50);
        Box box = new Box(new Point(0,0 ), new Point(60, 70));
        GeoResults<Shop> result = repository.findByLocationNear(p, oneKilometer);
        List<Shop> resultCircle = repository.findByLocationWithin(circle);
        List<Shop> resultStoresCircle = repository.findByStoreLocationWithin(circle2);
        List<Shop> resultBox = repository.findByLocationWithin(box);
       // List<Shop> resultPointInvalid = repository.findByLocationWithin(p);
        List<Shop> shops = repository.findByLocationNear(p, 0, 15);

        System.out.println(" - in distance: ");
        for (GeoResult<Shop> next : result.getContent()) {
            System.out.println(next.getDistance());
        }
        System.out.println(" - within circle: ");
        for (Shop next : resultCircle) {
            System.out.println(next.toString());
        }
        System.out.println(" - within box:");
        for (Shop next : resultBox) {
            System.out.println(next.toString());
        }
        System.out.println(" - near point:");
        for (Shop next : shops) {
            System.out.println(next.toString());
        }
        System.out.println(" - within stores in circle: ");
        for (Shop next : resultStoresCircle) {
            System.out.println(next.toString());
        }
    }
}
