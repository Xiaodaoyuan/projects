package com.xiaody.application.model.enums;

import java.io.Serializable;

public interface Identifiable<T> extends Serializable {
	T getId();
}
