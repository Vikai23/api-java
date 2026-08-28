package com.senac.tsi.MinhaPrimeiraApi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employee")
    public List<Employee> GetAll(){
        return repository.findAll();
    }

 @GetMapping("/employee/{id}")
    public Employee getEmployeeById (@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
 };

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    @PutMapping("/employee/{id}")
    public  Employee updateOrCreateEmployeeById(@RequestBody Employee newEmployee , @PathVariable long id) {
        return  repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                }).orElseGet(() ->
                repository.save(newEmployee));

    }


    @DeleteMapping ("/employee/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        repository.deleteById(id);
    }




}
