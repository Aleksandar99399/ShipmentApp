package finalproject.web;

import finalproject.models.bindings.UserLoginBindingModel;
import finalproject.models.bindings.UserRegisterBindingModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserRegisterBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("user") UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "confirmPassword",
                    "The passwords are not equal!");
        }
        if (this.userService.emailNotExist(userRegisterBindingModel.getEmail())!=null) {
            bindingResult.rejectValue("email", "email", "The email is not free!");
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }
        this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserLoginBindingModel());
        return "login";
    }


//    @GetMapping("/logout")
//    public String logout(HttpSession httpSession) {
//        httpSession.invalidate();
//        return "redirect:/";
//    }

}
