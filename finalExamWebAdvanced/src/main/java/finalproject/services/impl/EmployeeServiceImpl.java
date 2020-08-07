package finalproject.services.impl;

import finalproject.models.entities.*;
import finalproject.models.serviceModels.EmployeeServiceModel;
import finalproject.repositories.EmployeeRepository;
import finalproject.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final UserService userService;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final TownService townService;

    public EmployeeServiceImpl(UserService userService, EmployeeRepository employeeRepository, ModelMapper modelMapper, RoleService roleService, OfficeService officeService, TownService townService) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public void addEmployee(EmployeeServiceModel serviceModel) {

        Employee employee=this.modelMapper.map(serviceModel,Employee.class);


        User user=this.userService.saveUserRole(this.modelMapper.map(serviceModel.getUser(),User.class));

        employee.setUser(user);

        this.employeeRepository.save(employee);
    }

    @Override
    public void checkAdmin() {
        if (employeeRepository.count()==0){
            User userServiceAdminByRole = this.userService.findAdminByRole("ROLE_EMPLOYEE");
            Office office = this.townService.saveAdminInOfficeAndEmployee();

            Employee employee1=new Employee();
            employee1.setUser(userServiceAdminByRole);
            employee1.setOffice(office);
            employee1.setPosition(Position.RECEPTION);

            this.employeeRepository.save(employee1);
        }
    }

    @Override
    public boolean checkCount(){
        return this.employeeRepository.count()==0;
    }

    @Override
    public Employee findEmployee(String email) {
        return this.employeeRepository.findEmployee(email).orElse(null);

    }

    @Override
    public Employee findByUserAndOffice(User user,Office office) {
        return this.employeeRepository.findByUserAndOffice(user,office).orElse(null);
    }

    @Override
    public void addAdminAsEmployee(Employee employee) {

    }

    @Override
    public void saveAdminInEmployee() {
        this.userService.getOffice();
    }
}
