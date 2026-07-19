package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private HashMap<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable = new HashMap<>();

    public void addNewTrainingSession(TrainingSession trainingSession) {
        DayOfWeek dayOfWeek = trainingSession.getDayOfWeek();
        if (!timetable.containsKey(dayOfWeek)) {
            timetable.put(dayOfWeek, new TreeMap<>());//сохраняем занятие в расписании
        }
        TimeOfDay time = trainingSession.getTimeOfDay();
        TreeMap<TimeOfDay, List<TrainingSession>> daySchedule = timetable.get(dayOfWeek);
        if (!daySchedule.containsKey(time)) {
            daySchedule.put(time, new ArrayList<>());
        }
        daySchedule.get(time).add(trainingSession);
    }

    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        TreeMap<TimeOfDay, List<TrainingSession>> daySchedule = timetable.get(dayOfWeek);
        if (daySchedule == null) {
            return new ArrayList<>();
        }
        List<TrainingSession> result = new ArrayList<>();
        for (List<TrainingSession> sessions : daySchedule.values()) {
            result.addAll(sessions);//как реализовать, тоже непонятно, но сложность должна быть О(1)
        }
        return result;
    }

    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        TreeMap<TimeOfDay, List<TrainingSession>> daySchedule = timetable.get(dayOfWeek);
        if (daySchedule == null) {
            return new ArrayList<>();//как реализовать, тоже непонятно, но сложность должна быть О(1)
        }
        List<TrainingSession> sessions = daySchedule.get(timeOfDay);
        if (sessions == null) {
            return new ArrayList<>();
        }
        return sessions;
    }

    public List<CounterOfTrainings> getCountByCoaches() {
        Map<Coach, Integer> coachCounters = new HashMap<>();
        for (TreeMap<TimeOfDay, List<TrainingSession>> daySchedule : timetable.values()) {
            for (List<TrainingSession> sessions : daySchedule.values()) {
                for (TrainingSession session : sessions) {
                    Coach coach = session.getCoach();
                    int count = coachCounters.getOrDefault(coach, 0);
                    coachCounters.put(coach, count + 1);
                }
            }
        }
        List<CounterOfTrainings> counters = new ArrayList<>();

        for (Map.Entry<Coach, Integer> entry : coachCounters.entrySet()) {

            Coach coach = entry.getKey();
            int count = entry.getValue();

            CounterOfTrainings counter = new CounterOfTrainings(coach, count);
            counters.add(counter);
        }
        Collections.sort(counters);
        return counters;
    }
}
