package finalproject.services;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Office;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.EmployeeServiceModel;

public interface EmployeeService {

    void addEmployee(EmployeeServiceModel serviceModel);

    void checkAdmin();

    boolean checkCount();

    Employee findEmployee(String email);

    Employee findByUserAndOffice(User user, Office office);

    void addAdminAsEmployee(Employee employee);

    void saveAdminInEmployee();
}
