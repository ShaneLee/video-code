package co.uk.codeyogi.cucumber.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration
{
    @Value("${mongo.database}")
    private String mongoDatabase;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoClient mongoClient)
    {
        return new MongoTemplate(mongoClient, mongoDatabase);
    }
}
