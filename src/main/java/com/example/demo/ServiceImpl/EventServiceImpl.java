package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Event;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Service.EventService;

@Service
public class EventServiceImpl  implements EventService{

	    @Autowired
	    private EventRepository eventRepository;

	    @Override
	    public Event addEvent(Event event) {
	        return eventRepository.save(event);
	    }

	    @Override
	    public List<Event> getAllEvents() {
	    	  List<Event> events = eventRepository.findAll();
	    	    System.out.println("Retrieved events: " + events);
	    	    return events;
	    }

	    @Override
	    public Event getEventById(Long id) {
	        return eventRepository.findById(id).orElse(null); // Return null if not found
	    }

	    @Override
	    public Event updateEvent(Long id, Event event) {
	        if (!eventRepository.existsById(id)) {
	            return null; // Event does not exist
	        }
	        event.setId(id); // Set the ID for the event to update
	        return eventRepository.save(event);
	    }

	    @Override
	    public boolean deleteEvent(Long id) {
	        if (!eventRepository.existsById(id)) {
	            return false; // Event does not exist
	        }
	        eventRepository.deleteById(id);
	        return true;

	    }
   }
