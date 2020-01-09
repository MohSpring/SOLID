package hr.main;

import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;
import hr.taxes.TaxCalculatorFactory;
import hr.taxes.TaxeCalculator;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateTaxeMain {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository( employeeFileSerializer );

        //grab employees

        List<Employee> employees = employeeRepository.findAll();

        // get currency

            Locale locale = new Locale( "en", "CA" );
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance( locale );

        //    calculate taxes
        double totalTaxes = 0;
        for( Employee employee: employees ){
            TaxeCalculator taxeCalculator = TaxCalculatorFactory.create( employee );
            double tax = taxeCalculator.calculate( employee );
            String formatTax = currencyFormatter.format( tax );
            consoleLogger.logInfo( employee.getFullName()+" taxes: "+formatTax );
            totalTaxes += tax;
        }

        consoleLogger.logInfo( "the company total taxes are : "+ totalTaxes );
        //    add to company total taxes
    }


}
