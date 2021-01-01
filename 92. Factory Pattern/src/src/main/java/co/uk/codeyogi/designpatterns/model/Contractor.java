package co.uk.codeyogi.designpatterns.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Contractor implements Resource
{
    private static final int hoursWorked = 10;

    private final Object dayRateCalculator;

    private final Object workingHoursTracker;

    @Override
    public int calculateBillableHours()
    {
        return hoursWorked;
    }
}
