package api.java;

public class EmployeeNotFoundException extends RuntimeException{

    EmployeeNotFoundException(long id){
        super("Could not find employee with ID: " +id);
    }
}


