package com.miracle.database.connection;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.miracle.database.exception.DatabaseException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

@Configuration
@ConfigurationProperties
//@EnableMongoRepositories({ "com.miracle.database.repositories" })
public class MongoConnection {

	private static final String MONGO_DB_URL = "mongodb://";
	private static final boolean MONGO_DB_SSL = false;

	@Autowired
	private Environment env;

	@Bean
	public MongoClient mongo() {
		MongoClient mongoClient = null;
		try {
			System.setProperty("DATABASE", env.getProperty("mongodb.db"));
			MongoClientOptions.Builder options = MongoClientOptions.builder().sslEnabled(MONGO_DB_SSL)
					.sslInvalidHostNameAllowed(true);
			
			String dbUrl = new String(Base64.decodeBase64(env.getProperty("mongodb.url")));

			MongoClientURI connectionString = new MongoClientURI(
					MONGO_DB_URL + env.getProperty("mongodb.username") + ":" + env.getProperty("mongodb.password") + "@"
							+ dbUrl + ":" + env.getProperty("mongodb.port") + "/" + env.getProperty("mongodb.admin.db"),
					options);

			mongoClient = new MongoClient(connectionString);

			PrintStream printStream = System.out;
			ByteArrayOutputStream file = new ByteArrayOutputStream();
			System.setOut(new PrintStream(file));

//			Thread.sleep(50000);
			String texto = new String(file.toByteArray());

			System.setOut(printStream);
			if (texto.contains("Exception")) {
				throw new DatabaseException(texto);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
//			throw new DatabaseException(exception, "Failed to open MongoDB connection");
			System.exit(0);
		}
		return mongoClient;

	}
}
