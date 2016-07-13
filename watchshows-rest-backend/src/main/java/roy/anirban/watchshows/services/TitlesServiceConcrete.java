package roy.anirban.watchshows.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import roy.anirban.watchshows.entities.Actor;
import roy.anirban.watchshows.entities.Country;
import roy.anirban.watchshows.entities.Director;
import roy.anirban.watchshows.entities.Genere;
import roy.anirban.watchshows.entities.Language;
import roy.anirban.watchshows.entities.Plot;
import roy.anirban.watchshows.entities.Title;
import roy.anirban.watchshows.entities.Writer;
import roy.anirban.watchshows.repository.TitlesRepository;

@Service
@Transactional
public class TitlesServiceConcrete implements TitlesService {
	
	@Autowired
	private TitlesRepository titlerepository;
	
	@Override
	public Title createTitle(Title title) {
		List<Director> directors = title.getDirectors();
		List<Actor> actors = title.getActors();
		List<Country> countries = title.getReleasedcountries();
		List<Language> languages = title.getReleasedlanguages();
		List<Genere> generes = title.getApplicablegeneres();
		List<Writer> writers = title.getWriters();
		Plot plot = title.getPlot();
		
		//title = titlerepository.createTitle(title);
		validateDirectors(directors);
		validateActors(actors);
		validateCountries(countries);
		validateWriters(writers);
		validateGeneres(generes);
		validateLanguages(languages);
		
		titlerepository.createPlot(plot);
		titlerepository.createTitle(title);
		return title;
	}
	
	private void validateLanguages(List<Language> languages) {
		Language lang;
		for(Language language:languages){
			lang = titlerepository.checkLanguage(language);
			if(lang!=null){
				language.setId(lang.getId());
			}else{
				lang = titlerepository.createLanguage(language);
				language.setId(lang.getId());
			}
				
		}
	}

	private void validateGeneres(List<Genere> generes) {
		Genere gen;
		for(Genere genere:generes){
			gen = titlerepository.checkGenere(genere);
			if(gen!=null){
				genere.setId(gen.getId());
			}else{
				gen = titlerepository.createGenere(genere);
				genere.setId(gen.getId());
			}
				
		}
	}

	private void validateWriters(List<Writer> writers) {
		Writer wtr;
		for(Writer writer:writers){
			wtr = titlerepository.checkWriter(writer);
			if(wtr!=null){
				writer.setId(wtr.getId());
			}else{
				wtr = titlerepository.createWriter(writer);
				writer.setId(wtr.getId());
			}	
		}
	}

	public void validateDirectors(List<Director> directors){
		Director dir;
		for(Director director:directors){
			dir = titlerepository.checkDirector(director);
			if(dir!=null){
				director.setId(dir.getId());
			}else{
				dir = titlerepository.createDirector(director);
				director.setId(dir.getId());
			}
				
		}
	}
	
	public void validateActors(List<Actor> actors){
		Actor a;
		for(Actor actor:actors){
			a = titlerepository.checkActor(actor);
			if(a!=null){
				actor.setId(a.getId());
			}else{
				a = titlerepository.createActor(actor);
				actor.setId(a.getId());
			}
				
		}
	}
	
	public void validateCountries(List<Country> countries){
		Country c;
		for(Country country:countries){
			c = titlerepository.checkCountry(country);
			if(c!=null){
				country.setId(c.getId());
			}else{
				c = titlerepository.createCountry(country);
				country.setId(c.getId());
			}
				
		}
	}
	
	@Override
	public List<Title> getTitles() {
		// TODO Auto-generated method stub
		List<Title> titles = titlerepository.getTitles();
		
		// Initialize and load the collections from DB
		for(Title title: titles){
			title.getActors().size();
			title.getApplicablegeneres().size();
			title.getDirectors().size();
			title.getReleasedcountries().size();
			title.getReleasedlanguages().size();
			title.getWriters().size();
		}
		return titles;
	}

	@Override
	public Title getTitle(int id) {
		// TODO Auto-generated method stub
		Title title = titlerepository.getTitle(id);
		// initialize fill up the collections
		if(title!=null){
			title.getActors().size();
			title.getApplicablegeneres().size();
			title.getDirectors().size();
			title.getReleasedcountries().size();
			title.getReleasedlanguages().size();
			title.getWriters().size();
		}
		return title;
	}

	@Override
	public int updateTitle(Title title) {
		// TODO Auto-generated method stub
		int code = 0;
		
		//title = titlerepository.createTitle(title);
		List<Director> directors = title.getDirectors();
		List<Actor> actors = title.getActors();
		List<Country> countries = title.getReleasedcountries();
		List<Language> languages = title.getReleasedlanguages();
		List<Genere> generes = title.getApplicablegeneres();
		List<Writer> writers = title.getWriters();
		Plot plot = title.getPlot();
		
		//title = titlerepository.createTitle(title);
		validateDirectors(directors);
		validateActors(actors);
		validateCountries(countries);
		validateWriters(writers);
		validateGeneres(generes);
		validateLanguages(languages);
		
		//titlerepository.createPlot(plot);
		return titlerepository.updateTitle(title);
	}

	@Override
	public int deleteTitle(int id) {
		Title title = titlerepository.getTitle(id);
		if(title==null)
			return -1;
		return titlerepository.deleteTitle(title);
	}

}
