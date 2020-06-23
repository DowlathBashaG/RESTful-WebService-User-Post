package io.dowlath.rest.usercontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import io.dowlath.rest.exception.UserNotFoundException;
import io.dowlath.rest.model.Post;
import io.dowlath.rest.model.User;
import io.dowlath.rest.repository.PostRepository;
import io.dowlath.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaController {

	private static final String ServletUriBuilderComponent = null;
	private static final ResponseEntity<Object> ReponseEntity = null;
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}	
	
//	@GetMapping("/users/{id}")
//	public Resource<User> retrieveUser(@PathVariable int id) {
//		User user=  userDaoService.findOne(id);
//		if(user == null) {
//			throw new UserNotFoundException("id- ,"+id);
//		
//		}
//		
//		Resource<User> resource = new Resource<User>(user);
//		
//		ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
//		
//		resource.add(link.withRel("all-users"));
//				
//		return resource;
//	}
	
	
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user=  userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id- ,"+id);
		
		}
				
		return user;
	}
	
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ReponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepository.deleteById(id);
	
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable  int id){
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-,"+id);
		}
		return userOptional.get().getPosts();
	}	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> addPost(@PathVariable int id,@RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-,"+id);
		}
		
		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(post.getId()).toUri();
		return ReponseEntity.created(location).build();
		
	}
	
}
