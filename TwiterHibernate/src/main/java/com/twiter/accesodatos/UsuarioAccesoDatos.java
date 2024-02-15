package com.twiter.accesodatos;

import static com.twiter.accesodatos.AccesoDatos.enTransaccion;

import com.twiter.entidades.Usuario;

import jakarta.persistence.Query;

public class UsuarioAccesoDatos {
	public static void insertar(Usuario usuario) {
		enTransaccion(em -> {
			em.persist(usuario);
			return null;
		});
	}

	public static Usuario buscarPorNickName(String nickName){
		return enTransaccion(em ->{
			System.err.println("\n BuscarPorNickName");
			var usuario = em.
					createQuery("select usuario from Usuario as usuario join fetch usuario.rol where usuario.nickName = :nickName", Usuario.class).
					setParameter("nickName", nickName).getResultList();
			if(usuario.size()==1) {
				return usuario.get(0);
			}else {
				return null;
			}
		});
	}
	
	public static void agregarSeguidor(long id, long seguirA) {
		enTransaccion(em -> {
			Query query = em.createNativeQuery("INSERT INTO seguidores (usuario_id, seguidor_de_id) VALUES (:id, :seguirA)");
			
			query.setParameter("id", id);		
			query.setParameter("seguirA", seguirA);
			query.executeUpdate();
			
			return null;
		});
	}
}
