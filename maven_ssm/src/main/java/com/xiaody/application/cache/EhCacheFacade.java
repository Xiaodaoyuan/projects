package com.xiaody.application.cache;

import java.util.concurrent.Callable;

import com.xiaody.application.util.CloneUtils;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

//EhCacheFacade
public enum EhCacheFacade {
	CACHE;

	private Ehcache internal = CacheManager.getInstance().getCache(this.name());

	public <V> void put(String key, V value) {
		internal.put(new Element(normalize(key), CloneUtils.clone(value)));
	}

	@SuppressWarnings("unchecked")
	public <V> V get(String key) {
		Element element = internal.get(normalize(key));
		return element == null ? null : CloneUtils.clone((V) element.getObjectValue());
	}

	@SuppressWarnings("unchecked")
	public <V> V get(String key, Callable<V> call) throws Exception {
		Element element = internal.get(normalize(key));
		V value;
		if (element == null) {
			value = call.call();
			put(key, value);
		} else {
			value = CloneUtils.clone((V) element.getObjectValue());
		}
		return value;
	}

	private String normalize(String key) {
		return key == null ? null : key.toLowerCase();
	}
}
