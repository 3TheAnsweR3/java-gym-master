# Gym Master

Gym Master is an educational Java domain model for a gym timetable. The project practises object-oriented design, nested collections, ordering, filtering, and unit testing.

> Educational project. It represents coursework rather than commercial development experience.

## Features

- Represent coaches, groups, age categories, days, times, and training sessions.
- Add sessions to a timetable.
- Return all sessions for a selected day in chronological order.
- Return sessions for a specific day and start time.
- Support several sessions beginning at the same time.
- Count sessions by coach and sort the result by workload.

## Data structure

The timetable groups sessions by day and then by time:

```text
Map<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>>
```

This structure preserves chronological order while allowing more than one group to train at the same time.

## Technology

- Java 21
- Object-oriented programming
- Collections: `HashMap`, `TreeMap`, and `List`
- `Comparable` and sorting
- JUnit 5
- GitHub Actions

The project includes tests for day-based lookup, chronological ordering, time-based lookup, and simultaneous sessions.

## Run and test

Open the project in IntelliJ IDEA, select JDK 21, and run `TimetableTest`. The project is a domain-model exercise and does not currently include a separate command-line or web interface.
