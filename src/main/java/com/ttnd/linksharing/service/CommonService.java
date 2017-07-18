package com.ttnd.linksharing.service;

import java.util.List;

public interface CommonService<T> {

	public T get(Integer id);

	public List<T> list(Integer limit, Integer offset);

	public T saveOrUpdate(T t);

	public void delete(T t);
}
