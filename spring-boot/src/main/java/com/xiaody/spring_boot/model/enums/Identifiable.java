package com.xiaody.spring_boot.model.enums;

import java.io.Serializable;

public interface Identifiable<T> extends Serializable {
	T getId();
}
