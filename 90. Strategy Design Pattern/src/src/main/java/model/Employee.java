package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import strategy.TaxStrategy;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class Employee
{
    @NonNull
    private final BigDecimal salary;
    @NonNull
    private final TaxStrategy taxStrategy;

    public BigDecimal calculateNetSalary()
    {
        return taxStrategy.calculate(this.salary);
    }
}
