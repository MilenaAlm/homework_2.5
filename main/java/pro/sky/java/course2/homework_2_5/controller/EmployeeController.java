package pro.sky.java.course2.homework_2_5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework_2_5.Employee;
import pro.sky.java.course2.homework_2_5.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать";
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lasttName) {
        return employeeService.addEmployee(firstName, lasttName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lasttName) {
        return employeeService.removeEmployee(firstName, lasttName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lasttName) {
        return employeeService.findEmployee(firstName, lasttName);
    }
}