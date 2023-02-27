package eus.birt.dam.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="noticia")
public class Noticia {
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="noticia")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;

	private String titulo;
	
    //@Column(length = 1024)
	private String texto;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechaNoticia = LocalDate.now();
	
	@OneToMany (mappedBy = "noticia",cascade = CascadeType.ALL)
	List <Comentario> comentarios = new ArrayList<>();

	public Noticia(String titulo, String texto) {
		super();
		this.titulo = titulo;
		this.texto = texto;
	}
	
	
}
