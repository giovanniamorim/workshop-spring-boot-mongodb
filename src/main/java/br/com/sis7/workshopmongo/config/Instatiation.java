package br.com.sis7.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.sis7.workshopmongo.domain.Post;
import br.com.sis7.workshopmongo.domain.Usuario;
import br.com.sis7.workshopmongo.dto.AutorDTO;
import br.com.sis7.workshopmongo.dto.ComentarioDTO;
import br.com.sis7.workshopmongo.repository.PostRepository;
import br.com.sis7.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Instatiation implements CommandLineRunner{
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.save(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abrcs", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/01/2018"), "Bom dia", "hoje acordei feliz", new AutorDTO(maria));
		
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite!", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		post1.getComentarios().addAll(Arrays.asList(c1,c2));
		post2.getComentarios().addAll(Arrays.asList(c3));
		
		usuarioRepository.save(Arrays.asList(maria, alex, bob));
		postRepository.save(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		usuarioRepository.save(maria);

		
	}

	
}
