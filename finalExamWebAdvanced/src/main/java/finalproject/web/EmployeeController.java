package finalproject.web;

import finalproject.models.bindings.EmployeeAddBindingModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.services.OfficeService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final OfficeService officeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public EmployeeController(OfficeService officeService, UserService userService, ModelMapper modelMapper) {
        this.officeService = officeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("empl",new EmployeeAddBindingModel());
        model.addAttribute("offices",officeService.findAllOffices());
        return "employee-add";
    }

    @PostMapping("/add")
    public String postAddEmployee(@Valid @ModelAttribute("empl") EmployeeAddBindingModel employeeAddBindingModel,
                                  BindingResult bindingResult,Model model){

        if (bindingResult.hasErrors()){
            return "redirect:add";
        }else {
            UserServiceModel userServiceModel = this.userService.emailNotExist(employeeAddBindingModel.getEmail());

            if (userServiceModel==null){
                //TODO handle exception
                return "redirect:add";
            }else {
                ;
                return "redirect:/home";
            }
        }
    }
}
