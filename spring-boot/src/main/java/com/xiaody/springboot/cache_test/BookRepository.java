package com.xiaody.springboot.cache_test;

public interface BookRepository {
	Book getByIsbn(String isbn);
}
