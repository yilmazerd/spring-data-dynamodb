package com.example.demo;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Set;

@DynamoDBTable(tableName = "CreateMyTable")
public class TestClass {

    private Long key;
    private double rangeKey;
    private Long version;

    private Set<Integer> integerSetAttribute;

    @DynamoDBHashKey
    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    @DynamoDBRangeKey
    public double getRangeKey() {
        return rangeKey;
    }

    public void setRangeKey(double rangeKey) {
        this.rangeKey = rangeKey;
    }

    @DynamoDBAttribute(attributeName = "integerSetAttribute")
    public Set<Integer> getIntegerAttribute() {
        return integerSetAttribute;
    }

    public void setIntegerAttribute(Set<Integer> integerAttribute) {
        this.integerSetAttribute = integerAttribute;
    }

    @DynamoDBVersionAttribute
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}