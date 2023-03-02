//AL FINAL NO LO USO
//package eus.birt.dam.bootstrap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import eus.birt.dam.domain.Usuario;
//import eus.birt.dam.repository.UsuarioRepository;
//
//
//
//@Component
//public class BootStrapData implements CommandLineRunner{
//	
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//	
//	
//	@Override
//	public void run(String... arg0) throws Exception {
//		//Creamos el usuario anónimo
//		Usuario usuario1 = new Usuario("Anónimo", "Anónimo","anonimo@birt.eus");
//		usuarioRepository.save(usuario1);
//        System.out.println("Usuarios en el respositorio: " + usuarioRepository.count());
//			
//	}
//	
//}