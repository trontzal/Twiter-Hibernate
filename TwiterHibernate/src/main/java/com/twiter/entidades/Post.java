package com.twiter.entidades;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "texto", nullable = false)
	private String texto;

	@ManyToOne
	@JoinColumn(name = "usuaio_id")
	private Usuario usuario;

	@ManyToMany(mappedBy = "postsRetwiteados")
	private Set<Usuario> usuariosQueHanRetwiteado = new HashSet<Usuario>();

	public Post() {
		super();
	}

	public Post(Long id, String texto, Usuario usuario, Set<Usuario> usuariosQueHanRetwiteado) {
		super();
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.usuariosQueHanRetwiteado = usuariosQueHanRetwiteado;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", texto=" + texto + ", usuario=" + usuario + ", usuariosQueHanRetwiteado="
				+ usuariosQueHanRetwiteado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, texto, usuario, usuariosQueHanRetwiteado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id) && Objects.equals(texto, other.texto)
				&& Objects.equals(usuario, other.usuario)
				&& Objects.equals(usuariosQueHanRetwiteado, other.usuariosQueHanRetwiteado);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Usuario> getUsuariosQueHanRetwiteado() {
		return usuariosQueHanRetwiteado;
	}

	public void setUsuariosQueHanRetwiteado(Set<Usuario> usuariosQueHanRetwiteado) {
		this.usuariosQueHanRetwiteado = usuariosQueHanRetwiteado;
	}

}
