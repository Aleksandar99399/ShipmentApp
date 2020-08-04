package finalproject.web;

import finalproject.errors.UserRegisterException;
import finalproject.models.bindings.UserLoginBindingModel;
import finalproject.models.bindings.UserRegisterBindingModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        if (!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel",new UserRegisterBindingModel());
        }
        return "register";
    }

    @ExceptionHandler({UserRegisterException.class})
    @PostMapping("/register")
    public ModelAndView postRegister(@Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes,UserRegisterException ex) {

        ModelAndView modelAndView=new ModelAndView();

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            modelAndView.setViewName("register");
        }else {
                this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
                modelAndView.setViewName("login");
        }
        return modelAndView;

    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserLoginBindingModel());
        return "login";
    }

    @PostMapping("/login-error")
    public ModelAndView onLoginError(
            @ModelAttribute("email") String email){
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("username",email);
        modelAndView.addObject("error","bad_credentials");
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
