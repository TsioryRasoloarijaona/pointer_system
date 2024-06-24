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
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        NormalHour forGuard= new NormalHour(10);
        Salary gardSalary = new Salary(10000);
        Category guard = new Category(CategoryName.guard , forGuard , gardSalary);
        Employe rakoto = new Employe("rakoto","rakoto", guard);
        NormalHour normalHour = new NormalHour(10);
        NightHour nightHour = new NightHour(0,0);
        ExtraHour extraHour = new ExtraHour(0,0);
        NormalDay normalDay = new NormalDay(Date.valueOf("2024-06-26") ,nightHour , normalHour , extraHour);
        NormalDay normalDay1 = new NormalDay(Date.valueOf("2024-06-27") ,nightHour , normalHour , extraHour);
        NormalDay normalDay2 = new NormalDay(Date.valueOf("2024-06-28") ,nightHour , normalHour , extraHour);
        NormalDay normalDay3 = new NormalDay(Date.valueOf("2024-06-29") ,nightHour , normalHour , extraHour);
        Sunday sunday = new Sunday(Date.valueOf("2024-06-29") , extraHour);
        Week week = new Week(List.of(normalDay , normalDay1 , normalDay2 , normalDay3 ), List.of(sunday));
        System.out.println(rakoto.salaryDetails(week));
    }
}