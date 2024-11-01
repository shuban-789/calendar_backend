package com.nighthawk.spring_portfolio.mvc.event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Event is a POJO, Plain Old Java Object.
 * --- @Data is Lombok annotation for @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
 * --- @AllArgsConstructor is Lombok annotation for a constructor with all arguments
 * --- @NoArgsConstructor is Lombok annotation for a constructor with no arguments
 * --- @Entity annotation is used to mark the class as a persistent Java class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

    /** automatic unique identifier for Event record */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Event attributes */
    @NotEmpty
    @Size(min = 3, max = 100, message = "Event name should be between 3 and 100 characters")
    private String name;

    @Column
    private String location;

    @Column
    private LocalDate date;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private String description;

    /** Optional JSON field to store additional details */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> additionalDetails = new HashMap<>();

    /** Custom constructor for Event when building a new Event object from an API call */
    public Event(String name, String location, LocalDate date, LocalTime startTime, LocalTime endTime, String description) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    /** Static method to initialize an array list of Event objects */
    public static List<Event> init() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("Math Lecture", "Room 101", LocalDate.of(2024, 11, 5), LocalTime.of(10, 0), LocalTime.of(11, 0), "An advanced mathematics lecture."));
        events.add(new Event("Science Fair", "Auditorium", LocalDate.of(2024, 11, 12), LocalTime.of(9, 0), LocalTime.of(15, 0), "Annual school science fair."));
        return events;
    }

    /** Static method to print Event objects from a list */
    public static void main(String[] args) {
        List<Event> events = init();
        for (Event event : events) {
            System.out.println(event);
        }
    }
}