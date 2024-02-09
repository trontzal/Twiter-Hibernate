package com.twiter.entidades;

import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "user")
	private String user;
	
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;

	public Usuario() {
	}

	public Usuario(Long id, String nickName, String usuario) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.user = usuario;
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

	public void setUser(String usuario) {
		this.user = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nickName, user);
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
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickName=" + nickName + ", usuario=" + user + "]";
	}
	
	
}
