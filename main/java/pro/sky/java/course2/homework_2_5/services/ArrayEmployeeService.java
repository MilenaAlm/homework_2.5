package pro.sky.java.course2.homework_2_5.services;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework_2_5.Employee;
import pro.sky.java.course2.homework_2_5.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework_2_5.Exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework_2_5.Exceptions.EmployeeStorageIsFullException;

@Service
public class ArrayEmployeeService implements EmployeeService{
    private static final int size  = 10;
    private final Employee[] employees = new Employee[size];

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        int indexForAdd = -1;
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length ; i++) {
            if (employees[i] == null && indexForAdd == -1) {
                indexForAdd = i;
            }
            if(employees[i]!=null && employees.equals(employee)){
                throw new EmployeeAlreadyAddedException();
                }
            }
            if (indexForAdd ==-1) {
                throw new EmployeeStorageIsFullException();
            }
            employees [indexForAdd] = employee;
            return employees [indexForAdd];
        }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employee.equals(employees[i])) {
                employees[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee emp : employees) {
            if (employees.equals(emp)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
