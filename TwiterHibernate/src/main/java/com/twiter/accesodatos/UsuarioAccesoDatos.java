package com.twiter.accesodatos;

import com.twiter.entidades.Usuario;
import static com.twiter.accesodatos.AccesoDatos.enTransaccion;

import java.io.ObjectInputStream.GetField;

public class UsuarioAccesoDatos {
	public static void insertar(Usuario usuario) {
		enTransaccion(em -> {
			em.persist(usuario);
			return null;
		});
	}

	public static Usuario buscarPorNickName(String nickName){
		return enTransaccion(em ->{
			var usuario = em.
					createQuery("select usuario from Usuario as usuario where usuario.nickName = :nickName", Usuario.class).
					setParameter("nickName", nickName).getResultList();
			if(usuario.size()==1) {
				return usuario.get(0);
			}else {
				return null;
			}
		});
	}
}
