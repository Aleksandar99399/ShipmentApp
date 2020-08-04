package finalproject.web;

import finalproject.models.bindings.OfficeAddBindingModel;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.services.OfficeService;
import finalproject.services.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/offices")
public class OfficeController {

    private final TownService townService;
    private final OfficeService officeService;
    private final ModelMapper modelMapper;

    public OfficeController(TownService townService, OfficeService officeService, ModelMapper modelMapper) {
        this.townService = townService;
        this.officeService = officeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addOffice(Model model){
        model.addAttribute("towns",this.townService.findAllTowns());
        model.addAttribute("office",new OfficeAddBindingModel());
        return "office-add";
    }

    @PostMapping("/add")
    public String postAddOffice(@Valid @ModelAttribute("office") OfficeAddBindingModel officeAddBindingModel,
                                BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "redirect:office-add";
        }else {
            this.officeService.addOffice(this.modelMapper.map(officeAddBindingModel, OfficeServiceModel.class));
            return "redirect:/home";
        }
    }
}
