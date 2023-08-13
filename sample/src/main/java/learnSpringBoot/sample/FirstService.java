package learnSpringBoot.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class FirstService {
static List<User> createUsers()
{
User u1=new User(1,"AAA",23);
User u2=new User(2,"BBB",28);
User u3=new User(3,"CCC",27);
List<User> a=new ArrayList<User>();
a.add(u1);a.add(u2);a.add(u3);
return a;}//list of users

List<User> b=createUsers();//b=a ,a value assigned into b
public List<User> getUsers()//get all users=
{return b;}

//post (add) user
public String addOneUser(User u)
{b.add(u);return "Users added successfully";}


//getuserbyid
public User getUserById(int id) {//only one users values to nbe writtern
for (User u: b) {// u is an user class reference
if (u.getId()==id) {return u;}}return null;}

//delete by id
public String deleteById(int id)
{Iterator<User> i=b.iterator();
while (i.hasNext())
{User u= i.next();
if (u.getId()==id){i.remove();}}//return u;
return "Successfully deleted";}}
