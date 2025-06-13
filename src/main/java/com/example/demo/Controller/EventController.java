package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Event;
import com.example.demo.Service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventController {
	
	    @Autowired
	    private EventService eventService;

	    @PostMapping
	    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
	        return ResponseEntity.ok(eventService.addEvent(event));
	    }
	    @GetMapping("/events")
	    public ResponseEntity<List<Event>> getAllEvents() {
	    	List<Event> events = eventService.getAllEvents();
	        return ResponseEntity.ok(events);   
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
	        Event event = eventService.getEventById(id);
	        return event != null ? ResponseEntity.ok(event) : ResponseEntity.notFound().build();
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
	        Event updatedEvent = eventService.updateEvent(id, event);
	        return updatedEvent != null ? ResponseEntity.ok(updatedEvent) : ResponseEntity.notFound().build();
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
	        return eventService.deleteEvent(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	    }
	}
	

