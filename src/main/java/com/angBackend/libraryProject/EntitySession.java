package com.angBackend.libraryProject;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntitySession {

	private static EntityManager entityManager;

	@Autowired
	public EntitySession(EntityManager entityManager) {
		EntitySession.entityManager = entityManager;
	}

	public static Session getSession() {
		return entityManager.unwrap(Session.class);
	}

}
