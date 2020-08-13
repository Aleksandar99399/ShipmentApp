package finalproject.web;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Office;
import finalproject.models.entities.Role;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.repositories.ShipmentRepository;
import finalproject.services.EmployeeService;
import finalproject.services.ShipmentService;
import finalproject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {

    private final ShipmentService shipmentService;
    private final EmployeeService employeeService;

    public IndexController(ShipmentService shipmentService, EmployeeService employeeService) {
        this.shipmentService = shipmentService;
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public String index(HttpSession session){
        if(session.getAttribute("email")!=null){
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal){
        String name = principal.getName();
        Office office = null;
        Employee employee=this.employeeService.findEmployee(name);

        if (employeeService.checkCount()){
            this.employeeService.checkAdmin();

        }else if (employee!=null){

            office=employee.getOffice();
            model.addAttribute("shipToMe", this.shipmentService.findAllByRecipients(false,office) );
            model.addAttribute("shipFromMe", this.shipmentService.findAllByRecipients(true,office) );

        }else {
            model.addAttribute("shipToMe", this.shipmentService.findAllShipmentsOnUser(name,false) );
            model.addAttribute("shipFromMe", this.shipmentService.findAllShipmentsOnUser(name,true) );

        }

        return "home";
    }


//    @GetMapping("/admin")
//    public ModelAndView admin(@AuthenticationPrincipal Principal principal){
//        ModelAndView mav= new ModelAndView("admin");
//        mav.addObject("user", principal);
//        return mav;
//    }
//
//    @GetMapping("/user")
//    public ModelAndView user(@AuthenticationPrincipal Principal principal){
//        ModelAndView mav= new ModelAndView("user");
//        mav.addObject("user", principal);
//        return mav;
//    }
}