package com.xiaody.application.cache;

import java.util.concurrent.Callable;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public enum EhCacheFacade {
	CACHE;

	private Ehcache internal = CacheManager.getInstance().getCache(this.name());

	public <V> void put(String key, V value) {
		internal.put(new Element(normalize(key), value));
	}

	public <V> V get(String key) {
		Element element = internal.get(normalize(key));
		return element == null ? null : (V) element.getObjectValue();
	}

	public <V> V get(String key, Callable<V> call) throws Exception {
		Element element = internal.get(normalize(key));
		V value;
		if (element == null) {
			value = call.call();
			put(key, value);
		} else {
			value = (V) element.getObjectValue();
		}
		return value;
	}

	private String normalize(String key) {
		return key == null ? null : key.toLowerCase();
	}
}
