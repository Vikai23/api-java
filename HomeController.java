package com.senac.tsi.aiai;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String HelloWord(){
        return "HelloWord";
    }

    @GetMapping("/employeeTest")
    public Employee EmployeeTest(){
        var empregado = new Employee();
        empregado.setName("Vinicius");
        return empregado;
    }


}
