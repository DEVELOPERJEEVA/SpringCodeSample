package learnSpringBoot.sample;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Service {
	@Autowired
	UserRepository ur;
	@Autowired
	PostRepository pr;

	public List<User>getAllUserService(){
		return ur.findAll();
	}
	
	
	public Optional<User>getOneUserService1(int id)
	{
		Optional<User> u=ur.findById(id);
		if(!u.isPresent())
		{
			throw new UserNotFoundException("id-"+id);
		}
		else
		{
			return u;
		}
	}
	
	
	public Optional<User>getOneUserService(int id)
	{
		Optional<User> u=ur.findById(id);
		if(!u.isPresent())
		{
			throw new UserNotFoundException("id-"+id);
		}
		else
		{
			return u;
		}
		
		
	}
	public String deleteUserService(int id)
	{
		Optional<User> u=ur.findById(id);
		if(!u.isPresent())
		{
			throw new UserNotFoundException("id-"+id);
		}
		else
		{
			ur.deleteById(id);
			return "deleted successfully";
		}
		
		
	}
	public String addUserService(User u) {
		ur.save(u);
		return "User added Successfully";
		
	}
		
	public String UpdateUserService(int id,User u) {
		Optional<User> us=ur.findById(id);
		if(!us.isPresent())
		{
			throw new UserNotFoundException("id-"+id);
		}
		else
		{
			u.setId(id);
			ur.save(u);
			return "Updated successfully";
		}
		
		
	}
	

	public List<Post> getUserPostSer(int id)
	{
		Optional<User> u=ur.findById(id);
		if(!u.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return u.get().getP();//get user and themselves post we will return
	}
	
	public ResponseEntity<Object> addUserPostSer(int id,Post post)
	{
		Optional<User> u=ur.findById(id);
		if(!u.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		User user =u.get();
		post.setU(user);
		pr.save(post);
		
		URI location =
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
				
				return ResponseEntity.created(location).build();
		
	}
	}

