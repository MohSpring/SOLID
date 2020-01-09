package hr.taxes;

import hr.personnel.Employee;

public class PartTimeTaxCalculator implements TaxeCalculator {
    private final int RETIREMENT_TAX_PERCENTAGE = 5;
    private final int INCOME_TAX_PERCENTAGE = 16;
    private final int BASE_HEALTH_INSURANCE = 100;

    @Override public double calculate(Employee employee) {
        return BASE_HEALTH_INSURANCE + (employee.getMonthlyIncome() * INCOME_TAX_PERCENTAGE) / 100 + (employee.getMonthlyIncome() * RETIREMENT_TAX_PERCENTAGE) / 100;
    }
}
