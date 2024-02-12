package com.twiter.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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
	
	@Column(name = "nick_name", nullable = false, length = 100)
	private String nickName;
	
	@ManyToOne
	@JoinColumn(name = "roles_id", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_rol"))
	private Rol rol;

	@ManyToMany
	@JoinTable(name = "posts_retwiteados", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "post_id"), foreignKey = @ForeignKey(name = "FK_post_retwiteado_por_usuario"), inverseForeignKey = @ForeignKey(name = "FK_usuario_retwitea_post"))
	private Set<Post> aRetwiteado;
	
	@ManyToMany
	@JoinTable(name = "seguidores", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "seguidor_de_id"))
	private Set<Usuario> seguidorDe;
	
	public Usuario() {
	}
}