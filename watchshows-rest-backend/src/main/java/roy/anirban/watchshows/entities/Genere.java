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

@Table(name="generes_types")
@Entity
public class Genere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@JsonProperty(value="Genere")
	@Column(name="genere")
	String genere;
	
	@JsonIgnore  // Ignore during the serialization to JSON by Jackson
	@ManyToMany(mappedBy="applicablegeneres", fetch = FetchType.LAZY)
	List<Title> titlesunder;
	
	public Genere() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenere() {
		return genere;
	}
	
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@JsonIgnore
	public List<Title> getTitlesunder() {
		return titlesunder;
	}
	
	public void setTitlesunder(List<Title> titlesunder) {
		this.titlesunder = titlesunder;
	}	
}
