package pro.sky.java.course2.homework_2_5.services;

import pro.sky.java.course2.homework_2_5.Employee;

public interface EmployeeService {

    Employee addEmployee (String firstName, String lastName);
    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
}
