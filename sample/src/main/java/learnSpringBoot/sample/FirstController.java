package learnSpringBoot.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// why we given here instead of controller
@RequestMapping("/user")
public class FirstController {
@Autowired
FirstService service;//service is an object 

@GetMapping("/getalluser")
public List<User> getAllUser()
{return Service.getUser();}// service is an object this got from FirstService


@GetMapping("/getoneusers/{id}")//only one user we need
public User getOneUser(@PathVariable int id)// we need only one user so that 
{User u= service.getUserById(id);return u;}


@DeleteMapping("/deleteusers/{id}")
public String deleteUser(@PathVariable int id)// we need only one user we can use path variable
{  return service.deleteById(id);}


@PostMapping("/postusers")
public String addUser(@RequestBody User u)
{return service.addOneUser(u);}}
