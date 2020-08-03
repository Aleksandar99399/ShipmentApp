package finalproject.services.impl;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.EmployeeServiceModel;
import finalproject.repositories.EmployeeRepository;
import finalproject.services.EmployeeService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final UserService userService;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(UserService userService, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void addEmployee(EmployeeServiceModel serviceModel) {
        Employee employee=this.modelMapper.map(serviceModel,Employee.class);
        User user=serviceModel.getUser();
        user.getRoles().add(new Role("ROLE_EMPLOYEE"));
        employee.setUser(user);
        this.userService.saveUserRole(user);


        this.employeeRepository.save(employee);
    }
}
