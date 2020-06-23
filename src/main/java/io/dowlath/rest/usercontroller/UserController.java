package io.dowlath.rest.usercontroller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import io.dowlath.rest.exception.UserNotFoundException;
import io.dowlath.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.dowlath.rest.userservice.UserDaoService;

@RestController
public class UserController {

	private static final String ServletUriBuilderComponent = null;
	private static final ResponseEntity<Object> ReponseEntity = null;
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userDaoService.findAll();
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
	
	
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user=  userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id- ,"+id);
		
		}
				
		return user;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ReponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		User deleteUser = userDaoService.deleteById(id);
		if(deleteUser == null) {
			throw new UserNotFoundException("id-,"+ id);
		}
	}
}
