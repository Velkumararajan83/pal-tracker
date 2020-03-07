package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.pal.tracker.repository.TimeEntryRepository;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
	private TimeEntryRepository repository;
	
	
	public TimeEntryController(TimeEntryRepository repository) {
		setRepository(repository);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
		TimeEntry createdTimeEntry = getRepository().create(timeEntry);
		
		return new ResponseEntity<TimeEntry>(createdTimeEntry, HttpStatus.CREATED);
	}
	
	
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
		TimeEntry timeEntry = getRepository().find(id);
		
		if(timeEntry != null) {
			return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
		}else {
			return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TimeEntry>> list() {
		
		return new ResponseEntity<List<TimeEntry>>(repository.list(), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	@ResponseBody
	public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
		TimeEntry updateTime = getRepository().update(id, timeEntry);
		
		if(updateTime != null) {
			return new ResponseEntity<TimeEntry>(updateTime, HttpStatus.OK);
		}else {
			return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
		
		getRepository().delete(id);
		
		return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * @return the repository
	 */
	public TimeEntryRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(TimeEntryRepository repository) {
		this.repository = repository;
	}
}
