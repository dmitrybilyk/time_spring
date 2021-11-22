//package com.learn.time.time.batch.importxmltodb.configuration;
//
//import com.learn.time.time.batch.importxmltodb.model.Coffee;
//import org.springframework.batch.item.file.mapping.FieldSetMapper;
//import org.springframework.batch.item.file.transform.FieldSet;
//import org.springframework.boot.context.properties.bind.BindException;
//
//public class RecordFieldSetMapper implements FieldSetMapper<Coffee> {
//
//    public Coffee mapFieldSet(FieldSet fieldSet) throws BindException {
//        Coffee coffee = new Coffee();
//
//        coffee.setBrand(fieldSet.readRawString(0));
//        coffee.setOrigin(fieldSet.readRawString(1));
//        coffee.setCharacteristics(fieldSet.readRawString(2));
//        return coffee;
//    }
//}