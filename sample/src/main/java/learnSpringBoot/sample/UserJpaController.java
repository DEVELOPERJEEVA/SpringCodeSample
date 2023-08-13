package learnSpringBoot.sample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJpaController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Service service;
	
	@GetMapping("/jpa/getusers")
	public List<User> getAllUser()
	{return userRepository.findAll();}//user repository within find all method is there
	
	
	@GetMapping("/jpa/getoneusers/{id}")
	public Optional<User>getOneUser(@PathVariable int id) {Optional<User> u=userRepository.findById(id);	return u;}
	
	
	@PostMapping("/jpa/postUser")
	public String addUser(@RequestBody User u) {userRepository.save(u) ;	return "successfully added";}
	
	
	@DeleteMapping("/jpa/deleteuser/{id}")
	public void deleteUser(@PathVariable int id) {	userRepository.deleteById(id);  System.out.println("successfully deleted");}
	
	//post
	@GetMapping("/db/getUser/{id}/post")
	public List<Post> getUserPost(@PathVariable int id) {return service.getUserPostSer(id);}
	
	@PostMapping("/db/getUser/{id}/post")
	public ResponseEntity<Object> addUserPostser(@PathVariable int id,@RequestBody Post post){
		return service.addUserPostSer(id,post);	}
}
