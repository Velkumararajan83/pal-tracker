package io.pivotal.pal.tracker.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.pivotal.pal.tracker.TimeEntry;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

	public Map<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry>();
	long maxId = 0L;
	
	public TimeEntry create(TimeEntry timeEntry) {
		if(timeEntry.getId() == 0L) {
			long id = maxId + 1;
			maxId = maxId + 1;
			timeEntry.setId(id);
		}
		timeEntries.put(timeEntry.getId(), timeEntry);
		
		return timeEntry;
	}
	
	public TimeEntry find(Long timeEntryId) {
		return timeEntries.get(timeEntryId);
	}
	
	public List<TimeEntry> list() {
		return new ArrayList<TimeEntry>(timeEntries.values());
	}
	
	public TimeEntry update(Long id, TimeEntry timeEntry) {
		if(timeEntries.keySet().contains(id)) {
			timeEntries.put(id, timeEntry);
			timeEntry.setId(id);
			return timeEntry;
		}
		
		return null;
	}
	
	public void delete(Long id) {
		timeEntries.remove(id);
	}
}
