package com.twiter.accesodatos;

import com.twiter.entidades.Usuario;
import static com.twiter.accesodatos.AccesoDatos.enTransaccion;

public class UsuarioAccesoDatos {
	public static void insertar(Usuario usuario) {
		enTransaccion(em -> {
			em.persist(usuario);
			return null;
		});
	}
}
