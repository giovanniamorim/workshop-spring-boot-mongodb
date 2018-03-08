package br.com.sis7.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis7.workshopmongo.domain.Usuario;
import br.com.sis7.workshopmongo.dto.UsuarioDTO;
import br.com.sis7.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> list = usuarioService.findAll();
		List<UsuarioDTO> listDto = list.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}

}
