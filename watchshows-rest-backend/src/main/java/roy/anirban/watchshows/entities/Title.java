package roy.anirban.watchshows.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="titles")
public class Title {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@JsonProperty(value="Title")
	@Column(name="title")
	String titlename;
	@JsonProperty(value="Year")
	@Column(name="year")
	int year;
	@JsonProperty(value="Rated")
	@Column(name="rated")
	String rated;
	@JsonProperty(value="Released")
	@Column(name="release_date")
	Date released_date;
	@JsonProperty(value="Runtime")
	@Column(name="runtime")
	int runtime;
	@JsonProperty(value="Metascore")
	@Column(name="metascore")
	int metascore;
	@JsonProperty(value="imdbRating")
	@Column(name="imdbrating")
	float imdbrating;
	@JsonProperty(value="imdbVotes")
	@Column(name="imdbvotes")
	long imdbvotes;
	@JsonProperty(value="Type")
	@Column(name="type")
	String type;
	@JsonProperty(value="Awards")
	@Column(name="awards")
	String awards;
	@JsonProperty(value="Poster")
	@Column(name="poster")
	String posterurl;
	
	@JsonProperty(value="Plot")
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id")
	Plot plot;
	
	@JsonProperty(value="Directors")
	@JoinTable(
		      name="directors",
		      joinColumns=@JoinColumn(name="title_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="director_crew_id", referencedColumnName="id"))
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Director> directors;
	
	@JsonProperty(value="Actors")
	@JoinTable(
		      name="actors",
		      joinColumns=@JoinColumn(name="title_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="actor_crew_id", referencedColumnName="id"))
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Actor> actors;
	
	@JsonProperty(value="Writers")
	@JoinTable(
		      name="writers",
		      joinColumns=@JoinColumn(name="title_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="writer_crew_id", referencedColumnName="id"))
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Writer> writers;
	
	@JsonProperty(value="Generes")
	@JoinTable(
		      name="title_generes",
		      joinColumns=@JoinColumn(name="title_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="genere_id", referencedColumnName="id"))
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Genere> applicablegeneres;
	
	@JsonProperty(value="Languages")
	@JoinTable(
		      name="title_released_languages",
		      joinColumns=@JoinColumn(name="title_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="language_id", referencedColumnName="id"))
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Language> releasedlanguages;
	
	@JsonProperty(value="Countries")
	@JoinTable(
		      name="title_released_country",
		      joinColumns=@JoinColumn(name="title_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="country_id", referencedColumnName="id"))
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Country> releasedcountries;
	
	// no arg contructor mandatory for persistence API
	public Title(){
		
	}
	public Title(int id, String name, int year){
		this.id = id;
		this.titlename = name;
		this.year = year;
	}
	
	public Title(String name, int year){
		this.titlename = name;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitlename() {
		return titlename;
	}
	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public Date getReleased_date() {
		return released_date;
	}
	public void setReleased_date(Date released_date) {
		this.released_date = released_date;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getMetascore() {
		return metascore;
	}
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	public float getImdbrating() {
		return imdbrating;
	}
	public void setImdbrating(float imdbrating) {
		this.imdbrating = imdbrating;
	}
	public long getImdbvotes() {
		return imdbvotes;
	}
	public void setImdbvotes(long imdbvotes) {
		this.imdbvotes = imdbvotes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPosterurl() {
		return posterurl;
	}
	public void setPosterurl(String posterurl) {
		this.posterurl = posterurl;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public List<Writer> getWriters() {
		return writers;
	}
	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}
	public List<Genere> getApplicablegeneres() {
		return applicablegeneres;
	}
	public void setApplicablegeneres(List<Genere> applicablegeneres) {
		this.applicablegeneres = applicablegeneres;
	}
	public List<Language> getReleasedlanguages() {
		return releasedlanguages;
	}
	public void setReleasedlanguages(List<Language> releasedlanguages) {
		this.releasedlanguages = releasedlanguages;
	}
	public List<Country> getReleasedcountries() {
		return releasedcountries;
	}
	public void setReleasedcountries(List<Country> releasedcountries) {
		this.releasedcountries = releasedcountries;
	}
	
}
