package br.com.sis7.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis7.workshopmongo.domain.Post;
import br.com.sis7.workshopmongo.repository.PostRepository;
import br.com.sis7.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id) {
		Post post = postRepository.findOne(id);
		if(post == null) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
		return post;
	}
	
	public List<Post> findByTitulo(String text){
		return postRepository.buscaTitulo(text);
	}
	
	public List<Post> buscaCompleta(String text, Date minDate, Date maxDate){
		minDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.buscaCompleta(text, minDate, maxDate);
	}
	
	
}
