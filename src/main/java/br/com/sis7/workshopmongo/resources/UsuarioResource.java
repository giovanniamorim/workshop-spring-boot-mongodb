package br.com.sis7.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@GetMapping("/{id}")
	public ResponseEntity <UsuarioDTO> findByid(@PathVariable String id){
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO usuarioDto){
		Usuario usuario = usuarioService.fromDTO(usuarioDto);
		usuario = usuarioService.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UsuarioDTO usuarioDto, @PathVariable String id){
		Usuario usuario = usuarioService.fromDTO(usuarioDto);
		usuario.setId(id);
		usuario = usuarioService.update(usuario);
		return ResponseEntity.noContent().build();
	}


}
