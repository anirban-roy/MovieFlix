package roy.anirban.watchshows.repository;

import java.util.List;

import roy.anirban.watchshows.entities.Actor;
import roy.anirban.watchshows.entities.Country;
import roy.anirban.watchshows.entities.Director;
import roy.anirban.watchshows.entities.Genere;
import roy.anirban.watchshows.entities.Language;
import roy.anirban.watchshows.entities.Plot;
import roy.anirban.watchshows.entities.Title;
import roy.anirban.watchshows.entities.Writer;

public interface TitlesRepository {
	// Core operations
	public Title createTitle(Title title);
	public List<Title> getTitles();
	public Title getTitle(int id);
	public int updateTitle(Title title);
	public int deleteTitle(Title title);
	
	// Helpers
	public Director checkDirector(Director director);
	public Director createDirector(Director director);
	public Actor checkActor(Actor actor);
	public Actor createActor(Actor actor);
	public Language checkLanguage(Language language);
	public Language createLanguage(Language language);
	public Country checkCountry(Country country);
	public Country createCountry(Country country);
	public Genere checkGenere(Genere genere);
	public Genere createGenere(Genere genere);
	public Writer checkWriter(Writer writer);
	public Writer createWriter(Writer writer);
	public Plot createPlot(Plot plot);
	public Plot updatePlot(Plot plot);
	
}
