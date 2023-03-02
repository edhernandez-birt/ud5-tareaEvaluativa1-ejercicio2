package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.ComentarioRepository;
import eus.birt.dam.repository.NoticiaRepository;
import eus.birt.dam.repository.UsuarioRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private ComentarioRepository comentarioRepository;
	@Autowired
   	private NoticiaRepository noticiaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping ({"/","/welcome","/index"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/comentarios"})
	public String getComentrios(Model model) {
		model.addAttribute("comentarios", comentarioRepository.findAll());
		return "comentarios";
	}
	
	@GetMapping ({"/noticias"})
	public String getNoticias(Model model) {
		model.addAttribute("noticias", noticiaRepository.findAll());
		return "noticias";
	}
	
	@GetMapping ({"/usuarios"})
	public String getUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuarios";
	}
}
	

