package eus.birt.dam.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comentario")
public class Comentario {
	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",schema="noticia")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;
	
	@Column(name="texto")
	private String texto;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechaComentario = LocalDate.now();
	
	
	@ManyToOne
	@JoinColumn (name = "noticia_id")
	private Noticia noticia;

	public Comentario(String texto) {
		super();
		this.texto = texto;
	}
}
