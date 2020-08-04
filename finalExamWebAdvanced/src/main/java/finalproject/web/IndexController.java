package finalproject.web;

import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.repositories.ShipmentRepository;
import finalproject.services.ShipmentService;
import finalproject.services.UserService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.springsecurity5.auth.Authorization;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {

    private final UserService userService;
    private final ShipmentService shipmentService;
    private final ShipmentRepository shipmentRepository;

    public IndexController(UserService userService, ShipmentService shipmentService, ShipmentRepository shipmentRepository) {
        this.userService = userService;
        this.shipmentService = shipmentService;
        this.shipmentRepository = shipmentRepository;
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

       model.addAttribute("shipToMe", this.shipmentService.findAllByRecipients(name,false) );
       model.addAttribute("shipFromMe", this.shipmentService.findAllByRecipients(name,true) );
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