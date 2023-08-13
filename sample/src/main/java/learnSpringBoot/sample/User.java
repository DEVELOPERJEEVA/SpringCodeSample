package learnSpringBoot.sample;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userss")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String age;
	
	@OneToMany(mappedBy="u",cascade = CascadeType.ALL)
	private List<Post> p;
	
	public List<Post> getP() {
		return p;
	}

	public void setP(List<Post> p) {
		this.p = p;
	}

	
	
	protected User()
	{
	
	}
	
	public User(Integer id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}
