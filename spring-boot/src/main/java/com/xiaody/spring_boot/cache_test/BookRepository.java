package com.xiaody.spring_boot.cache_test;

public interface BookRepository {
	Book getByIsbn(String isbn);
}
