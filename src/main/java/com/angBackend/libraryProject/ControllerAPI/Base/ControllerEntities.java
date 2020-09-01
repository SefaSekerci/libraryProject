package com.angBackend.libraryProject.ControllerAPI.Base;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.angBackend.libraryProject.Entities.IEntity;

public interface ControllerEntities<T extends IEntity> {
	
	public ResponseEntity<T> add(T t);
	
	public ResponseEntity<List<T>> getList();
	
	public ResponseEntity<T> getById(Long id);
	
	public ResponseEntity<String> deleteById(Long id);
	
	public ResponseEntity<T> updatebyId(T t, Long id); 

}
