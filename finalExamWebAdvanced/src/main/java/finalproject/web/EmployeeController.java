package finalproject.web;

import finalproject.errors.OfficeIsExist;
import finalproject.errors.OfficeNotFoundException;
import finalproject.errors.UserNotFoundException;
import finalproject.models.bindings.EmployeeAddBindingModel;
import finalproject.models.bindings.EmployeeLoginBindingModel;
import finalproject.models.entities.Employee;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("towns",this.townService.findAllTowns());
        model.addAttribute("offices",officeService.findAllOffices());
        if (!model.containsAttribute("empl")) {
            model.addAttribute("empl", new EmployeeAddBindingModel());
        }
        return "employee-add";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public String postAddEmployee(@Valid @ModelAttribute("empl") EmployeeAddBindingModel employeeAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("empl", employeeAddBindingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.empl", bindingResult);

            return "redirect:add";
        }else {
            UserServiceModel userServiceModel = this.userService.emailNotExist(employeeAddBindingModel.getEmail());
            OfficeServiceModel officeServiceModel=this.officeService.findById(employeeAddBindingModel.getOffice());


            if (userServiceModel==null){

                redirectAttributes.addFlashAttribute("empl", employeeAddBindingModel);
                redirectAttributes.addFlashAttribute
                        ("org.springframework.validation.BindingResult.empl", bindingResult);

                throw new UserNotFoundException();

            }else if (officeServiceModel==null){

                throw new OfficeNotFoundException();

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
