package com.salary;

import com.salary.calendar.day.Holiday;
import com.salary.calendar.day.NormalDay;
import com.salary.calendar.day.Sunday;
import com.salary.calendar.hours.ExtraHour;
import com.salary.calendar.hours.NightHour;
import com.salary.calendar.hours.NormalHour;
import com.salary.calendar.month.Week;
import com.salary.categories.Category;
import com.salary.categories.CategoryName;
import com.salary.employe.Employe;
import com.salary.salary.Salary;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        NormalHour forGuard= new NormalHour(10);
        Salary guardSalary = new Salary(100000);
        Category guard = new Category(CategoryName.guard , forGuard , guardSalary);
        Employe rakoto = new Employe("rakoto","rakoto", guard);
        NormalHour normalHour = new NormalHour(10);
        NightHour nightHour = new NightHour(0,1.5);
        ExtraHour extrahourRakoto = new ExtraHour(0,1.5);
        ExtraHour forHoliday = new ExtraHour(10 , 1.3);
        NormalDay normalDay = new NormalDay(Date.valueOf("2024-06-18") ,nightHour , normalHour , extrahourRakoto);
        List<NormalDay>mayToJuly = new ArrayList<>();
        for (int i = 0 ; i < 39 ; i++){
            mayToJuly.add(normalDay);
        }
       Holiday holiday1 = new Holiday(Date.valueOf("2024-06-17") , forHoliday);
        Holiday holiday2 = new Holiday(Date.valueOf("2024-06-25") , forHoliday);
        Holiday holiday3 = new Holiday(Date.valueOf("2024-06-26") , forHoliday);
        Sunday sunday = new Sunday(Date.valueOf("2024-06-29") , extrahourRakoto);

        Week week = new Week(mayToJuly, List.of(sunday) , List.of(holiday1 , holiday2 , holiday3));
        System.out.println(rakoto.salaryDetails(week));

       // System.out.println(guard.brutPerHour()*10);

    }
}