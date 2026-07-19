package ru.yandex.practicum.gym;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TimetableTest {

    @Test
    void testGetTrainingSessionsForDaySingleSession() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");

        TrainingSession singleTrainingSession = new TrainingSession(group, coach, DayOfWeek.MONDAY,
                new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        List<TrainingSession> monday = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);

        List<TrainingSession> tuesday = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);

        Assertions.assertEquals(1, monday.size());
        Assertions.assertEquals(singleTrainingSession, monday.get(0));
        Assertions.assertTrue(tuesday.isEmpty());
    }

    @Test
    void testGetTrainingSessionsForDayMultipleSessions() {

        Timetable timetable = new Timetable();

        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");

        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        TrainingSession thursdayAdultTrainingSession = new TrainingSession(groupAdult, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(20, 0));

        timetable.addNewTrainingSession(thursdayAdultTrainingSession);

        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);

        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));
        TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(13, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.SATURDAY, new TimeOfDay(10, 0));

        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);

        List<TrainingSession> monday = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        List<TrainingSession> thursday = timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY);
        List<TrainingSession> tuesday = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);

        Assertions.assertEquals(1, monday.size());
        Assertions.assertEquals(2, thursday.size());
        Assertions.assertEquals(thursdayChildTrainingSession, thursday.get(0));
        Assertions.assertEquals(thursdayAdultTrainingSession, thursday.get(1));
        Assertions.assertTrue(tuesday.isEmpty());
    }

    @Test
    void testGetTrainingSessionsForDayAndTime() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");

        TrainingSession singleTrainingSession = new TrainingSession(group, coach, DayOfWeek.MONDAY,
                new TimeOfDay(13, 0));
        timetable.addNewTrainingSession(singleTrainingSession);

        List<TrainingSession> sessions13 = timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY,
                new TimeOfDay(13, 0));
        List<TrainingSession> sessions14 = timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY,
                new TimeOfDay(14, 0));
        Assertions.assertEquals(1, sessions13.size());
        Assertions.assertEquals(singleTrainingSession, sessions13.get(0));
        Assertions.assertTrue(sessions14.isEmpty());
    }
}
