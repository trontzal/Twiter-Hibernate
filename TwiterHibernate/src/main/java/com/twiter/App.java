package com.twiter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		// Iniciar la sesión de Hibernate
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TwiterApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
//        // Crear una instancia de Usuario
//        Usuario usuario = new Usuario();
//        usuario.setNickName("usuario1");
//        usuario.setUser("nombredeusuario1");
//
//        // Iniciar una transacción para guardar el usuario en la base de datos
//        entityManager.getTransaction().begin();
//        entityManager.persist(usuario);
//        entityManager.getTransaction().commit();
        
        // Cerrar la sesión de Hibernate
        entityManager.close();
        entityManagerFactory.close();
	}

}
