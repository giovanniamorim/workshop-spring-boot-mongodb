package br.com.sis7.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.sis7.workshopmongo.domain.Usuario;
import br.com.sis7.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Instatiation implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... arg0) throws Exception{
		
		usuarioRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.save(Arrays.asList(maria, alex, bob));

		
	}

	
}
