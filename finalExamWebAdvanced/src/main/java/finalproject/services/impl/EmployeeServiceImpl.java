package finalproject.services.impl;

import finalproject.models.serviceModels.EmployeeServiceModel;
import finalproject.repositories.EmployeeRepository;
import finalproject.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addEmployee(EmployeeServiceModel serviceModel) {

    }
}
