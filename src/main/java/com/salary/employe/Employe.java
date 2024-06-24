package com.salary.employe;

import com.salary.calendar.day.NormalDay;
import com.salary.calendar.month.Week;
import com.salary.categories.Category;
import com.salary.categories.CategoryName;
import com.salary.salary.Salary;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employe {
    private String firstname ;
    private String lastname ;
    private String birthdate;
    private String contractStart;
    private String contractEnd;
    private Category category;
    private Salary salary;

    public Employe(String firstname, String lastname, Category category) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.category = category;
    }

    private Salary salaryForSuperior (){
        return category.getSalaryPerWeek();
    }

    private Salary salaryForOthers(Week week){
        return perWeek(week);
    }

    public Salary salaryDetails (Week week){
        if (category.getCategoryName().equals(CategoryName.superior)){
            return salaryForSuperior();
        }
        return salaryForOthers(week);
    }


    private double salaryPerHour(){
        return category.brutPerHour();
    }

    private double forNormalDay (Week week){
        int totalHours = week.getNormalDays()
                .stream().mapToInt(d -> d.getNormalHour().getValue())
                .sum();

        List<NormalDay> withNight = week.getNormalDays()
                .stream().filter(d -> !d.getNightHour().equals(null))
                .toList();

        int totalNightHour = withNight
                .stream().mapToInt(d->d.getNightHour().getValue())
                .sum();

        double extraGainForNight = withNight.get(0).getNightHour().getExtraSupply() * salaryPerHour() * totalNightHour;

        List<NormalDay> extraHour = week.getNormalDays()
                .stream().filter(d-> !d.getExtraHour().equals(null))
                .toList();

        int totalExtraHour = extraHour.stream().mapToInt(d-> d.getExtraHour().getValue())
                .sum();

        double totalGainExtraHour = extraHour.get(0).getExtraHour().getExtraHourSupply() * salaryPerHour() * totalExtraHour;

        return salaryPerHour() * totalHours + totalGainExtraHour + extraGainForNight;


    }

    private double forHolidaysHours (Week week){
        int totalHours = 0 ;
        if (week.getHolidays() != null){

         totalHours = week.getHolidays()
                .stream().mapToInt(d->d.getExtraHour().getValue()).sum();
        return week.getHolidays().get(0).getExtraHour().getExtraHourSupply() * salaryPerHour() * totalHours;
        }else {
            totalHours = 0;
        }
        return 0;
    }

    private double forSundays (Week week){
        int totalHours = week.getSundays()
                .stream().mapToInt(d->d.getExtraHour().getValue()).sum();

        return week.getSundays().get(0).getExtraHour().getExtraHourSupply() * salaryPerHour() * totalHours;


    }

    private Salary perWeek(Week week){
        return new Salary(forSundays(week) + forHolidaysHours(week) + forNormalDay(week));
    }
}
