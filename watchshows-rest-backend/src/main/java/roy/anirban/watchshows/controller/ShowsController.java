package roy.anirban.watchshows.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import roy.anirban.watchshows.entities.Title;
import roy.anirban.watchshows.services.TitlesService;

@RestController
public class ShowsController {
	
	@Autowired
	TitlesService titleService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addtitle")
	public Title addTitle(@RequestBody Title title){
		return titleService.createTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/alltitles")
	public List<Title> getAllTitles(){
		return titleService.getTitles();
	}
	
	/**
	 * Find and return the title object based on the id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="/title/{id}")
	public Title getTitle(@PathVariable("id") int id){
		return titleService.getTitle(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatetitle")
	public ResponseEntity<String> updateTitle(@RequestBody Title title){
		int code = titleService.updateTitle(title);
		if(code<0)
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletetitle/{id}")
	public ResponseEntity<String> deleteTitle(@PathVariable("id") int id){
		int code = titleService.deleteTitle(id);
		if(code<0)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>(HttpStatus.OK);
	}
}
