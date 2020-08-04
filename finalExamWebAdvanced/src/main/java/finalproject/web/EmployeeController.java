package finalproject.web;

import finalproject.models.bindings.EmployeeAddBindingModel;
import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.EmployeeServiceModel;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.models.serviceModels.TownServiceModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.services.EmployeeService;
import finalproject.services.OfficeService;
import finalproject.services.TownService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class EmployeeController {

    private final TownService townService;
    private final OfficeService officeService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final EmployeeService employeeService;

    public EmployeeController(TownService townService, OfficeService officeService, UserService userService, ModelMapper modelMapper, EmployeeService employeeService) {
        this.townService = townService;
        this.officeService = officeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("towns",this.townService.findAllTowns());
        model.addAttribute("empl",new EmployeeAddBindingModel());
        model.addAttribute("offices",officeService.findAllOffices());
        return "employee-add";
    }

    @PostMapping("/add")
    public String postAddEmployee(@Valid @ModelAttribute("empl") EmployeeAddBindingModel employeeAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        //RedirectAddFlashAttributes
        if (bindingResult.hasErrors()){
            //redirectAttributes.addFlashAttribute()
            return "redirect:add";
        }else {
            UserServiceModel userServiceModel = this.userService.emailNotExist(employeeAddBindingModel.getEmail());
            OfficeServiceModel officeServiceModel=this.officeService.findById(employeeAddBindingModel.getOffice());


            if (userServiceModel==null || officeServiceModel==null){
                //TODO handle exception
                return "redirect:add";
            } else {


                EmployeeServiceModel serviceModel = new EmployeeServiceModel();
                serviceModel.setUser(userServiceModel);
                serviceModel.setOffice(officeServiceModel);
                serviceModel.setPosition(employeeAddBindingModel.getPosition());
                employeeService.addEmployee(serviceModel);
                return "redirect:/home";
            }
        }
    }
}
