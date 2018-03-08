package br.com.sis7.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis7.workshopmongo.domain.Usuario;
import br.com.sis7.workshopmongo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

}
