package roy.anirban.watchshows.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import roy.anirban.watchshows.entities.*;

@Repository
public class TitlesRepositoryConcrete implements TitlesRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Title createTitle(Title title) {
		// TODO Auto-generated method stub
		try{
			em.persist(title);
		}catch(EntityExistsException e){
			return null;
		}
		return title;
	}

	@Override
	public List<Title> getTitles() {
		// TODO Auto-generated method stub
		List<Title> shows; // = new ArrayList<>();
		TypedQuery<Title> query = em.createQuery("SELECT t FROM Title t", Title.class);
		shows = query.getResultList();
		/*Title t = shows.get(0);
		List<Director> d = t.getDirectors();*/
		//System.out.println(d.get(0).getName());
		
		return shows;
	}

	@Override
	public Title getTitle(int id) {
		// TODO Auto-generated method stub
		return em.find(Title.class, id);
	}

	@Override
	public int updateTitle(Title title) {
		
		try{
			em.merge(title);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		// TODO Auto-generated method stub
		try{
			em.remove(title);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public Director checkDirector(Director director) {
		// TODO Auto-generated method stub
		TypedQuery<Director> query = em.createQuery("SELECT d FROM Director d WHERE d.name LIKE :directorName", Director.class);
		query.setParameter("directorName", director.getName()+"%");
		List<Director> dirs = query.setMaxResults(1).getResultList();
		if(dirs.size()>0)
			return dirs.get(0);
		else
			return null;
	}
	
	@Override
	public Director createDirector(Director director) {
		// TODO Auto-generated method stub
		em.persist(director);
		return director;
	}
	
	@Override
	public Actor checkActor(Actor actor){
		TypedQuery<Actor> query = em.createQuery("SELECT a FROM Actor a WHERE a.name LIKE :actorName", Actor.class);
		query.setParameter("actorName", actor.getName()+"%");
		List<Actor> atrs = query.setMaxResults(1).getResultList();
		if(atrs.size()>0)
			return atrs.get(0);
		else
			return null;
	}
	
	@Override
	public Actor createActor(Actor actor){
		em.persist(actor);
		return actor;
	}

	@Override
	public Country checkCountry(Country country) {
		TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.countryname LIKE :countryName", Country.class);
		query.setParameter("countryName", country.getCountryname()+"%");
		List<Country> cntr = query.setMaxResults(1).getResultList();
		if(cntr.size()>0)
			return cntr.get(0);
		else
			return null;
	}
	
	@Override
	public Country createCountry(Country country) {
		// TODO Auto-generated method stub
		em.persist(country);
		return country;
	}
	
	@Override
	public Genere checkGenere(Genere genere) {
		TypedQuery<Genere> query = em.createQuery("SELECT g FROM Genere g WHERE g.genere LIKE :genereVal", Genere.class);
		query.setParameter("genereVal", genere.getGenere()+"%");
		List<Genere> gen = query.setMaxResults(1).getResultList();
		if(gen.size()>0)
			return gen.get(0);
		else
			return null;
	}
	
	@Override
	public Genere createGenere(Genere genere) {
		em.persist(genere);
		return genere;
	}
	
	@Override
	public Language checkLanguage(Language language) {
		TypedQuery<Language> query = em.createQuery("SELECT l FROM Language l WHERE l.language LIKE :lang", Language.class);
		query.setParameter("lang", language.getLanguage()+"%");
		List<Language> lan = query.setMaxResults(1).getResultList();
		if(lan.size()>0)
			return lan.get(0);
		else
			return null;
	}

	@Override
	public Language createLanguage(Language language) {
		em.persist(language);
		return language;
	}

	@Override
	public Writer checkWriter(Writer writer) {
		TypedQuery<Writer> query = em.createQuery("SELECT w FROM Writer w WHERE w.name LIKE :name", Writer.class);
		query.setParameter("name", writer.getName()+"%");
		List<Writer> wtr = query.setMaxResults(1).getResultList();
		if(wtr.size()>0)
			return wtr.get(0);
		else
			return null;
	}

	@Override
	public Writer createWriter(Writer writer) {
		// TODO Auto-generated method stub
		em.persist(writer);
		return writer;
	}

	@Override
	public Plot createPlot(Plot plot) {
		em.persist(plot);
		return plot;
	}
	
	@Override
	public Plot updatePlot(Plot plot) {
		em.merge(plot);
		return plot;
	}
	
}
