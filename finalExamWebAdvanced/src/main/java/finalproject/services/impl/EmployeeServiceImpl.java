package finalproject.services.impl;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Office;
import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.EmployeeServiceModel;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.repositories.EmployeeRepository;
import finalproject.services.EmployeeService;
import finalproject.services.OfficeService;
import finalproject.services.RoleService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final UserService userService;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final OfficeService officeService;

    public EmployeeServiceImpl(UserService userService, EmployeeRepository employeeRepository, ModelMapper modelMapper, RoleService roleService, OfficeService officeService) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.officeService = officeService;
    }

    @Override

    public void addEmployee(EmployeeServiceModel serviceModel) {

        Employee employee=this.modelMapper.map(serviceModel,Employee.class);
        User user=this.userService.saveUserRole(serviceModel.getUser());
        Office officeFromDb = this.officeService.getOfficeFromDb(serviceModel.getOffice());

        employee.setOffice(officeFromDb);
        employee.setUser(user);

        this.employeeRepository.save(employee);
    }
}
