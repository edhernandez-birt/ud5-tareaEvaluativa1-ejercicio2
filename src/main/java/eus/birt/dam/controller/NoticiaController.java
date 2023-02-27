package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Noticia;
import eus.birt.dam.repository.NoticiaRepository;

@Controller
@RequestMapping ("/noticias")
public class NoticiaController {

@Autowired
NoticiaRepository noticiaRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		noticiaRepository.deleteById(id);
	return "redirect:/noticias";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Noticia noticia = new Noticia();
		model.addAttribute("noticia", noticia);
		return "noticiaForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Noticia noticia) {
		noticiaRepository.save(noticia);
		return "redirect:/noticias";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("noticia", noticiaRepository.findById(id));
		return "noticiaForm";
	}
}
