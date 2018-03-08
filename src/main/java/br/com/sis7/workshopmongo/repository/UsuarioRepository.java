package br.com.sis7.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sis7.workshopmongo.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
