package roy.anirban.watchshows.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="cast_and_crew")
@Entity
public class Writer{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@JsonProperty(value="Writer")
	@Column(name="name")
	String name;
	
	@JsonIgnore  // Ignore during the serialization to JSON by Jackson
	@ManyToMany(mappedBy="writers", fetch = FetchType.LAZY)
	List<Title> written;
	
	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<Title> getWritten() {
		return written;
	}

	public void setWritten(List<Title> written) {
		this.written = written;
	}	
}
