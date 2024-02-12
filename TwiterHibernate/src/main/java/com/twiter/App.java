package com.twiter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		// Iniciar la sesión de Hibernate
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TwiterApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        
        // Cerrar la sesión de Hibernate
        entityManager.close();
        entityManagerFactory.close();
	}

}
