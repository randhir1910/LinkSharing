package com.ttnd.linksharing.dao;

import java.util.List;

public interface CommonDao<T> {

	public T get(Integer id);

	public List<T> list(Integer limit, Integer offset);

	public T saveOrUpdate(T t);

	public void delete(T t);
}
