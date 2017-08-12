package com.xiaody.spring_boot.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xiaody.spring_boot.model.enums.Identifiable;


public class EnumRegistry {
	 @SuppressWarnings("rawtypes")
	private static ConcurrentHashMap<Class, Map<Object, Enum>> registry = new ConcurrentHashMap<>();

	    private EnumRegistry() {

	    }

	    @SuppressWarnings("unchecked")
		public static <T extends Enum<?>> T resolve(Object id, Class<T> clazz) {
	        if (!Identifiable.class.isAssignableFrom(clazz)) {
	            throw new IllegalArgumentException("The enum should implement [Identifiable] interface.");
	        }

	        if (!registry.containsKey(clazz)) {
	            register(clazz);
	        }

	        return (T) registry.get(clazz).get(id);
	    }

	    private static <T extends Enum<?>> void register(Class<T> clazz) {
	        @SuppressWarnings("rawtypes")
			Map<Object, Enum> constantMap = new HashMap<Object, Enum>();

	        for (T constant : clazz.getEnumConstants()) {
	            Object id = ((Identifiable<?>) constant).getId();
	            constantMap.put(id, constant);
	        }

	        registry.putIfAbsent(clazz, constantMap);
	    }
}
