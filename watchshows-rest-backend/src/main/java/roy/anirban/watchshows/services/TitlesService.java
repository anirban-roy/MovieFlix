package roy.anirban.watchshows.services;

import java.util.List;

import roy.anirban.watchshows.entities.*;

public interface TitlesService {
	
	public Title createTitle(Title title);
	public List<Title> getTitles();
	public Title getTitle(int id);
	public int updateTitle(Title title);
	public int deleteTitle(int id);
}
