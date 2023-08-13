package learnSpringBoot.sample;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	@Id
	private Integer id;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="User_id")
	private User u;
	
	public User getU() {
		return u;
	}
	public void setU(User u)
	{
		this.u = u;
	}
	
	
	protected Post()
	{
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", u=" + u + "]";
	}
}
