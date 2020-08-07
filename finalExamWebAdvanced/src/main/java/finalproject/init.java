package finalproject;

import finalproject.models.entities.*;
import finalproject.models.serviceModels.EmployeeServiceModel;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.repositories.TownRepository;
import finalproject.services.EmployeeService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class init implements CommandLineRunner {
    private final TownRepository townRepository;
    private final EmployeeService employeeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public init(TownRepository townRepository, EmployeeService employeeService, UserService userService, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.employeeService = employeeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (townRepository.count()==0) {
            Town sofia = new Town().setName("Sofia");
            Office mladost = new Office().setTown(sofia).setName("Mladost");
            Office lulin = new Office().setTown(sofia).setName("Lulin");
            Office centre = new Office().setTown(sofia).setName("Centre");
            sofia.setOffices(List.of(mladost, lulin, centre));

            Town plovdiv = new Town().setName("Plovdiv");
            Office trakiq = new Office().setTown(plovdiv).setName("Trakiq");
            Office smirnenski = new Office().setTown(plovdiv).setName("Smirnenski");
            plovdiv.setOffices(List.of(trakiq, smirnenski));

            Town varna = new Town().setName("Varna");
            Office asparuhovo = new Office().setTown(varna).setName("Asparuhovo");
            Office galata = new Office().setTown(varna).setName("Garata");
            varna.setOffices(List.of(asparuhovo, galata));




            townRepository.saveAll(List.of(sofia, plovdiv, varna));

//            EmployeeServiceModel employeeServiceModel=new EmployeeServiceModel();
//            employeeServiceModel.setUser(this.userService.emailNotExist("sasho@sds.bg"));
//            employeeServiceModel.setOffice(this.modelMapper.map(centralen, OfficeServiceModel.class));
//            this.employeeService.addEmployee(employeeServiceModel);
        }
    }
}
