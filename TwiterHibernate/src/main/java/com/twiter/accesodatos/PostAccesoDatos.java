package com.twiter.accesodatos;

import static com.twiter.accesodatos.AccesoDatos.enTransaccion;

import java.util.List;

import com.twiter.entidades.Post;

public class PostAccesoDatos {
	public static void insert(Post post) {
		enTransaccion(em -> {
			em.persist(post);
			return null;
		});
	}

	public static List<Post> obtenerTodos() {
		System.err.println("\n obtenerTodosLosPosts");
		return enTransaccion(em -> em.createQuery(
				"select post from Post as post join fetch post.usuario join fetch usuario.rol order by post.fecha desc",
				Post.class).getResultList());
	}

	public static List<Post> obtenerPorIdUsuario(long id) {
		System.err.println("\n Obtener posts por usuario id");
		return enTransaccion(em -> em.createQuery(
				"select post from Post as post join fetch post.usuario where post.usuario.id = :id order by post.fecha desc",
				Post.class).setParameter("id", id).getResultList());
	}
}
