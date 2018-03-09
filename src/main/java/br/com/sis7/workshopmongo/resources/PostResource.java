package br.com.sis7.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis7.workshopmongo.domain.Post;
import br.com.sis7.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findByid(@PathVariable String id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
		
	}

}
