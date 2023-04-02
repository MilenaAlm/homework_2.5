package pro.sky.java.course2.homework_2_5.services;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework_2_5.Employee;
import pro.sky.java.course2.homework_2_5.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework_2_5.Exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework_2_5.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
@Primary
public class ListEmployeeService implements EmployeeService{
    private static final int SIZE = 10;
    private final List<Employee> employees = new ArrayList<>(SIZE);


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employees.size() >=SIZE){
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(temp)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employees.contains(temp)) {
            temp = null;
            return temp;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employees.contains(temp)) {
            return temp;
        }
            throw new EmployeeNotFoundException();
        }

    public List<Employee> list(){
        return Collections.unmodifiableList(employees);
    }
}
