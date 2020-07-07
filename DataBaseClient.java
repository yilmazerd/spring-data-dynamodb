package com.example.demo;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SpringBootApplication
public class DataBaseClient {

    public static void main(String[] args) {

//        AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard()
//                .withRegion(Regions.US_EAST_1)
//                .build();

        AmazonDynamoDB dynamoDBClient = new AmazonDynamoDBClient();

        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);

        /*
        Create table
         */
        //CreateTableRequest req = mapper.generateCreateTableRequest(TestClass.class);
        //// Table provision throughput is still required since it cannot be specified in your POJO
        //req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
        //// Fire off the CreateTableRequest using the low-level client
        //dynamoDBClient.createTable(req);

        Long hashKey = 106L;

        Random r = new Random();
        double randomValue = 10 + (100 - 10) * r.nextDouble();
        double rangeKey = randomValue;
        //mapper.save(TestClass.class, hashKey, rangeKey);
        TestClass tc = new TestClass();
        Set<Integer> integers = new HashSet<>();
        integers.add(22);
        tc.setKey(hashKey);
        tc.setRangeKey(rangeKey);
        tc.setIntegerAttribute(integers);
        mapper.save(tc);
        //TestClass obj = mapper.load(TestClass.class, hashKey, rangeKey);
        //mapper.delete(obj);

        //TestClass obj = mapper.load(TestClass.class, hashKey, rangeKey);
//        obj.getIntegerAttribute().add(42);
        //mapper.save(obj);
        //mapper.delete(obj);
    }
}
