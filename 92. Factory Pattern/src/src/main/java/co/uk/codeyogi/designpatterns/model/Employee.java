package co.uk.codeyogi.designpatterns.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Employee implements Resource
{
    // Hardcoded as unimportant for example.
    private static final int hoursWorked = 10;
    private static final int commuteTime = 2;

    private final Object salaryCalculator;

    private final Object holidayCalculator;

    private final Object workingHoursTracker;

    @Override
    public int calculateBillableHours()
    {
        return hoursWorked + commuteTime;
    }
}
