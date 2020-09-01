package com.angBackend.libraryProject.Service;

import java.util.List;

import com.angBackend.libraryProject.Entities.IEntity;

public interface IService<T extends IEntity> {

	List<T> getList();

	void save(T object);

	T update(T object);

	void delete(T object);

	T getRecordbyId(Long id);

}
