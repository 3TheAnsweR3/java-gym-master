package ru.yandex.practicum.gym;

import java.util.ArrayList;
import java.util.List;

public class CounterOfTrainings implements Comparable<CounterOfTrainings> {
    private final Coach coach;
    private final int count;

    public CounterOfTrainings(Coach coach, int count) {
        this.coach = coach;
        this.count = count;
    }

    @Override
    public int compareTo(CounterOfTrainings o) {
        return Integer.compare(o.count, this.count);
    }
    public Coach getCoach() {
        return coach;
    }
    public int getCount() {
        return count;
    }
}
