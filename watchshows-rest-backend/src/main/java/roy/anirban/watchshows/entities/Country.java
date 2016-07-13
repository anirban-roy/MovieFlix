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

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@JsonProperty(value="Country")
	@Column(name="countryname")
	String countryname;
	
	@JsonIgnore  // Ignore during the serialization to JSON by Jackson
	@ManyToMany(mappedBy="releasedcountries", fetch = FetchType.LAZY)
	List<Title> titlesunder;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	
	@JsonIgnore
	public List<Title> getTitlesunder() {
		return titlesunder;
	}
	
	public void setTitlesunder(List<Title> titlesunder) {
		this.titlesunder = titlesunder;
	}
	
}
