package com.miracle.database.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

@Configuration
@ConfigurationProperties
@EnableMongoRepositories({ "com.miracle.database.repositories" })
public class MongoConnection {

	private static final String MONGO_DB_URL = "mongodb://";
	private static final boolean MONGO_DB_SSL = true;

	@Value("${mongodb.url:#{null}}")
	private String MONGO_HOST;
	@Value("${mongodb.username:#{null}}")
	private String MONGO_USERNAME;
	@Value("${mongodb.password:#{null}}")
	private String MONGO_PASSWORD;
	@Value("${mongodb.db:#{null}}")
	private String MONGO_DB_NAME;
	@Value("${mongodb.port:#{null}}")
	private String MONGO_DB_PORT;

	@Bean
	public MongoClient mongo() {
		System.setProperty("DATABASE", MONGO_DB_NAME);
		MongoClientOptions.Builder options = MongoClientOptions.builder().sslEnabled(MONGO_DB_SSL)
				.sslInvalidHostNameAllowed(true);
		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL + MONGO_USERNAME + ":" + MONGO_PASSWORD + "@"
				+ MONGO_HOST + ":" + MONGO_DB_PORT + "/" + MONGO_DB_NAME, options);
		return new MongoClient(connectionString);
	}

}
