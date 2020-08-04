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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addOffice(Model model) {
        model.addAttribute("towns", this.townService.findAllTowns());

        if (!model.containsAttribute("office")) {

            model.addAttribute("office", new OfficeAddBindingModel());
        }
        return "office-add";
    }

    @PostMapping("/add")
    public String postAddOffice(@Valid @ModelAttribute("office") OfficeAddBindingModel officeAddBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("office", officeAddBindingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.office", bindingResult);

            return "redirect:office-add";
        } else {

            this.officeService.addOffice(this.modelMapper.map(officeAddBindingModel, OfficeServiceModel.class));

            return "redirect:/home";
        }
    }
}
