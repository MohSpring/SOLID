package hr.main;

import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeRepository repository = new EmployeeRepository( new EmployeeFileSerializer() );
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees) {
            try {
                repository.save( e );
                ConsoleLogger.logInfo( "employee: "+ e.getFullName()+" saved successfully" );
            } catch (IOException ex) {
                ConsoleLogger.logError( "can't save employee"+ e.getFullName(),ex );
            }

        }
    }
}
