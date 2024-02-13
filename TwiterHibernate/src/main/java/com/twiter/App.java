package com.twiter;

import com.twiter.accesodatos.RolAccesoDatos;
import com.twiter.accesodatos.UsuarioAccesoDatos;
import com.twiter.entidades.Rol;
import com.twiter.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		// roles para que se puedan crear usuarios
		RolAccesoDatos.insertar(new Rol(null, "rolAdmin"));
		
		// obtener el rol para poder usarlo al crear el usuario
		Rol rolAdmin = RolAccesoDatos.obtenerPorId(1);
		
		//registro (insert usuario)
		UsuarioAccesoDatos.insertar(new Usuario("gonzalo", "contra", rolAdmin));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void mainAntiguo(String[] args) {
		// Iniciar la sesión de Hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TwiterApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        
        // Cerrar la sesión de Hibernate
        em.close();
        emf.close();
	}

}
