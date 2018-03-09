package br.com.sis7.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sis7.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{'titulo' : {$regex: ?0, $options: 'i'}}")
	List<Post> buscaTitulo(String text);
	
	List<Post> findByTituloContainingIgnoreCase(String text);

}
