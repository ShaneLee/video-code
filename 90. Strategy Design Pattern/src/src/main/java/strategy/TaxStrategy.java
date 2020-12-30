package strategy;

import java.math.BigDecimal;

public interface TaxStrategy
{
    BigDecimal calculate(BigDecimal salary);
}
