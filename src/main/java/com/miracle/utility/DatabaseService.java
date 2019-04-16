package com.miracle.utility;

import java.util.Collection;
import java.util.List;

public interface DatabaseService {
	void init();

	Object findFilteredData(String key, Object value);

	Object loadAll();

	void delete(Object key);

	void deleteAll(Collection<Object> keys);

	void storeAll(List<Object> object);

	void store(Object object);

	Iterable<Object> loadAllKeys();
}
