package com.nighthawk.spring_portfolio.mvc.calendar;

import com.nighthawk.spring_portfolio.mvc.calendar.Event;
import com.nighthawk.spring_portfolio.mvc.calendar.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class CalendarViewController {

    @Autowired
    private EventService eventService;

    @GetMapping("/calendar")
    public String calendar() {
        // load HTML VIEW (calendar.html)
        return "calendar";
    }

    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}
