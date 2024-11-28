package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    @Bean
    public MappingMongoConverter mappingMongoConverter(
            MongoDatabaseFactory mongoDatabaseFactory,
            MongoMappingContext mongoMappingContext) {
        // Create a type mapper to avoid the _class field
        MongoTypeMapper typeMapper = new DefaultMongoTypeMapper(null);

        // Create the MappingMongoConverter with the necessary components
        MappingMongoConverter converter = new MappingMongoConverter(
                mongoDatabaseFactory,
                mongoMappingContext
        );
        converter.setTypeMapper(typeMapper); // Set the custom type mapper
        return converter;
    }
}