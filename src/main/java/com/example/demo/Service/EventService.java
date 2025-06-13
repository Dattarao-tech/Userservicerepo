package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Event;

public interface EventService {
	    Event addEvent(Event event);
	    List<Event> getAllEvents();
	    Event getEventById(Long id);
	    Event updateEvent(Long id, Event event);
	    boolean deleteEvent(Long id);
	    
}
