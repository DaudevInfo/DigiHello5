package com.aplose.digihello.dao;

import java.util.List;

public interface IDAO<T> {
	List<T> findAll();
}
