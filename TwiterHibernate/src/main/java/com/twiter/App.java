package com.twiter;

import com.twiter.accesodatos.PostAccesoDatos;
import com.twiter.accesodatos.RolAccesoDatos;
import com.twiter.accesodatos.UsuarioAccesoDatos;
import com.twiter.entidades.Post;
import com.twiter.entidades.Rol;
import com.twiter.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		// roles para que se puedan crear usuarios
		RolAccesoDatos.insertar(new Rol(null, "ADMIN"));
		RolAccesoDatos.insertar(new Rol(null, "USER"));
		
		// obtener el rol para poder usarlo al crear el usuario
		Rol rolAdmin = RolAccesoDatos.obtenerPorId(1);
		Rol rolUser = RolAccesoDatos.obtenerPorId(2);
		
		//registro (insert usuario)
		UsuarioAccesoDatos.insertar(new Usuario("gonzalo", "contra", rolAdmin));
		UsuarioAccesoDatos.insertar(new Usuario("pepe", "pepe", rolUser));
		UsuarioAccesoDatos.insertar(new Usuario("juan", "juan", rolUser));
		
		// loggeo (buscar el usuario)
		Usuario gonzalo = UsuarioAccesoDatos.buscarPorNickName("gonzalo");
		Usuario pepe = UsuarioAccesoDatos.buscarPorNickName("pepe");
		Usuario juan = UsuarioAccesoDatos.buscarPorNickName("juan");
		
		// gestion de posts
		Post primerPost = new Post(gonzalo, "Primer post de mi aplicacion de twiter");
		PostAccesoDatos.insert(primerPost);
		var posts = PostAccesoDatos.obtenerTodos();
		
		// seguimientos
		UsuarioAccesoDatos.agregarSeguidor(pepe.getId(), gonzalo.getId());
		
		// Salidas de consola ------------------------------------------------
		// Ver usuarios
		System.out.println(gonzalo);
		// Ver todos los posts
		System.out.println(posts);
		// Ver las personas a las que sigue gonzalo
		System.out.println();
		
		
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
