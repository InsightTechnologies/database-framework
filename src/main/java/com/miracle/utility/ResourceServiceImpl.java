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
import com.miracle.database.bean.Filter;
import com.miracle.database.bean.Resource;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Service
public class ResourceServiceImpl implements DatabaseService {

	@Autowired
	private MongoClient mongoClient;
	private static final String FILTER_COLLECTION = "resource";
	private static final String DATABASE_NAME = "DATABASE";

	private MongoCollection<Document> mongoCollection;
	private JacksonMongoCollection<Resource> filterCollection;

	public void init() {
		this.mongoCollection = mongoClient.getDatabase(System.getProperty(DATABASE_NAME))
				.getCollection(FILTER_COLLECTION);
		this.filterCollection = JacksonMongoCollection.<Resource>builder().build(mongoCollection, Resource.class);
	}

	@Override
	public Object findFilteredData(String key, Object value) {

		Bson bsonFilter = Filters.eq(key, (String) value);
		FindIterable<Document> findIt = mongoCollection.find(bsonFilter);
		Document doc = findIt.first();
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(doc.toJson(), Resource.class);
	}

	@Override
	public Object loadAll() {
		return (List<Resource>) filterCollection.find().into(new ArrayList<Resource>());
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
			filterCollection.save((Resource) object);
		}
	}

	@Override
	public void store(Object object) {
		filterCollection.save((Resource) object);
	}

	@Override
	public Iterable<Object> loadAllKeys() {
		Iterator<Resource> iterator = filterCollection.find().iterator();
		Set<Object> keys = new HashSet<>();

		while (iterator.hasNext()) {
			keys.add(iterator.next().get_id());
		}
		return keys;
	}

}
