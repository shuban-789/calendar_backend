package com.nighthawk.spring_portfolio.mvc.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class CalendarViewController {

    @Autowired
    private CalendarEventRepository eventService;

    @GetMapping("/calendar")
    public String calendar() {
        // load HTML VIEW (calendar.html)
        return "calendar";
    }

    @PostMapping("/add")
    public CalendarEvent addEvent(@RequestBody CalendarEvent event) {
        return eventService.saveEvent(event);
    }

    @GetMapping
    public List<CalendarEvent> getAllEvents() {
        return eventService.getAllEvents();
    }
}