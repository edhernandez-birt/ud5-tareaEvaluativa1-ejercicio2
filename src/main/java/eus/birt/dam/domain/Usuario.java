package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "email"})})

public class Usuario {
	@Id
	@SequenceGenerator(name = "col_gen3", sequenceName = "col_sqe3",schema="noticia")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen3")
	private Long id;

	private String nombre;
	
	private String apellidos;
	
	private String email;

	@OneToMany (mappedBy = "usuario",cascade = CascadeType.ALL)
	List <Comentario> comentarios = new ArrayList<>();

	public Usuario(String nombre, String apellidos, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	
	
}
