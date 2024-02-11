package com.twiter.entidades;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nick_name", nullable = false)
	private String nickName;

	@Column(name = "user", nullable = false, unique = true)
	private String user;

	@ManyToOne
	@JoinColumn(name = "roles_id")
	private Rol rol;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "usuario_retwitea_post", joinColumns = {
			@JoinColumn(name = "usuario_id") }, inverseJoinColumns = { @JoinColumn(name = "post_id") })
	private Set<Post> postsRetwiteados = new HashSet<>();

	public Usuario() {
	}

	public Usuario(Long id, String nickName, String user, Rol rol, Set<Post> postsRetwiteados) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.user = user;
		this.rol = rol;
		this.postsRetwiteados = postsRetwiteados;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickName=" + nickName + ", user=" + user + ", rol=" + rol
				+ ", postsRetwiteados=" + postsRetwiteados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nickName, postsRetwiteados, rol, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(postsRetwiteados, other.postsRetwiteados) && Objects.equals(rol, other.rol)
				&& Objects.equals(user, other.user);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Post> getPostsRetwiteados() {
		return postsRetwiteados;
	}

	public void setPostsRetwiteados(Set<Post> postsRetwiteados) {
		this.postsRetwiteados = postsRetwiteados;
	}

}