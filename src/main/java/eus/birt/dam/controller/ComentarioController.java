package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Comentario;
import eus.birt.dam.repository.ComentarioRepository;
import eus.birt.dam.repository.NoticiaRepository;

@Controller
@RequestMapping ("/comentarios")
public class ComentarioController {

	@Autowired
	ComentarioRepository comentarioRepository;
	
	@Autowired
	NoticiaRepository noticiaRepository;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		comentarioRepository.deleteById(id);
		return "redirect:/comentarios";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Comentario comentario = new Comentario();
		model.addAttribute("comentario", comentario);
		model.addAttribute("noticias", noticiaRepository.findAll());
		return "comentarioForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Comentario comentario) {
		comentarioRepository.save(comentario);
		return "redirect:/comentarios";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("comentario", comentarioRepository.findById(id));
		model.addAttribute("noticias", noticiaRepository.findAll());
		return "comentarioForm";
	}
}