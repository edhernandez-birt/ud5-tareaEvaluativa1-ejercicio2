package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Usuario;
import eus.birt.dam.repository.UsuarioRepository;

@Controller
@RequestMapping ("/usuarios")
public class UsuarioController {

@Autowired
UsuarioRepository usuarioRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
	return "redirect:/usuarios";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuarioForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("usuario", usuarioRepository.findById(id));
		return "usuarioForm";
	}
}
