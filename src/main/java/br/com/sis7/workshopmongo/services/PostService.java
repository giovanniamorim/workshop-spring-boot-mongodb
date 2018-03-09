package br.com.sis7.workshopmongo.services;

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
	
	
}
