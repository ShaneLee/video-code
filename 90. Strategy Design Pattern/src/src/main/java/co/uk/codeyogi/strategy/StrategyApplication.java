package co.uk.codeyogi.strategy;

import model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import strategy.AdditionalRateTax;
import strategy.HigherRateTax;
import strategy.LowerRateTax;

import java.math.BigDecimal;

@SpringBootApplication
public class StrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrategyApplication.class, args);
		example();
	}

	private static void example()
	{
		final Employee higherEmployee = new Employee(BigDecimal.valueOf(100000), new HigherRateTax());

		System.out.println("Higher rate employee");
		System.out.println(higherEmployee.calculateNetSalary());

		final Employee lowerEmployee = new Employee(BigDecimal.valueOf(100000), new LowerRateTax());

		System.out.println("Lower rate employee");
		System.out.println(lowerEmployee.calculateNetSalary());

		final Employee specialCase = new Employee(BigDecimal.valueOf(1000000),
				salary -> salary.subtract(salary.multiply(BigDecimal.valueOf(0.1))));

		System.out.println("Special Case employee");
		System.out.println(specialCase.calculateNetSalary());

		final Employee additionalEmployee = new Employee(BigDecimal.valueOf(100000), new AdditionalRateTax());

		System.out.println("Additional rate employee");
		System.out.println(additionalEmployee.calculateNetSalary());

	}

}
