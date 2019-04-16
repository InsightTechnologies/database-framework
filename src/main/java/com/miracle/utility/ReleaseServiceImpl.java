package com.miracle.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.mongojack.JacksonMongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miracle.database.bean.Release;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Service
public class ReleaseServiceImpl implements DatabaseService {

	@Autowired
	private MongoClient mongoClient;
	private static final String FILTER_COLLECTION = "release";
	private static final String DATABASE_NAME = "DATABASE";

	private MongoCollection<Document> mongoCollection;
	private JacksonMongoCollection<Release> filterCollection;

	public void init() {
		this.mongoCollection = mongoClient.getDatabase(System.getProperty(DATABASE_NAME))
				.getCollection(FILTER_COLLECTION);
		this.filterCollection = JacksonMongoCollection.<Release>builder().build(mongoCollection, Release.class);
	}

	@Override
	public Object findFilteredData(String key, Object value) {

		Bson bsonFilter = Filters.eq(key, (String) value);
		FindIterable<Document> findIt = mongoCollection.find(bsonFilter);
		Document doc = findIt.first();
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(doc.toJson(), Release.class);
	}

	@Override
	public Object loadAll() {
		return (List<Release>) filterCollection.find().into(new ArrayList<Release>());
	}

	@Override
	public void delete(Object key) {
		filterCollection.removeById(key);
	}

	@Override
	public void deleteAll(Collection<Object> keys) {
		for (Object key : keys) {
			filterCollection.removeById(key);
		}
	}

	@Override
	public void storeAll(List<Object> list) {
		for (Object object : list) {
			filterCollection.save((Release) object);
		}
	}

	@Override
	public void store(Object object) {
		filterCollection.save((Release) object);
	}

	@Override
	public Iterable<Object> loadAllKeys() {
		Iterator<Release> iterator = filterCollection.find().iterator();
		Set<Object> keys = new HashSet<>();

		while (iterator.hasNext()) {
			keys.add(iterator.next().getId());
		}
		return keys;
	}

}
