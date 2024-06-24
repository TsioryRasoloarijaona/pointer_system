package com.salary.calendar.week;

import com.salary.calendar.day.Holiday;
import com.salary.calendar.day.NormalDay;
import com.salary.calendar.day.Sunday;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Week {
    private List<NormalDay> normalDays;
    private List<Sunday> sundays;
    private List<Holiday> holidays;

    public Week(List<NormalDay> normalDays, List<Sunday> sundays) {
        this.normalDays = normalDays;
        this.sundays = sundays;
    }
}
