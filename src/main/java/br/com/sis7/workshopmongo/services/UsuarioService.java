package br.com.sis7.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis7.workshopmongo.domain.Usuario;
import br.com.sis7.workshopmongo.dto.UsuarioDTO;
import br.com.sis7.workshopmongo.repository.UsuarioRepository;
import br.com.sis7.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(String id) {
		Usuario usuario = usuarioRepository.findOne(id);
		if(usuario == null) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}
	
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.insert(usuario);
		
	}
	
	public void delete(String id) {
		findById(id);
		usuarioRepository.delete(id);
		
	}
	
	public Usuario update(Usuario usuario) {
		Usuario usuarioAtualizado = usuarioRepository.findOne(usuario.getId());
		updateData(usuarioAtualizado, usuario);
		return usuarioRepository.save(usuarioAtualizado);
	}
	
	private void updateData(Usuario usuarioAtualizado, Usuario usuario) {
		usuarioAtualizado.setNome(usuario.getNome());
		usuarioAtualizado.setEmail(usuario.getEmail());
	}

	public Usuario fromDTO(UsuarioDTO usuarioDto) {
		return new Usuario(usuarioDto.getId(), usuarioDto.getNome(), usuarioDto.getEmail());
	}

}
