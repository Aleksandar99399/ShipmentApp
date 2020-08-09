package finalproject.web;

import finalproject.models.bindings.ShipmentAddBindingModel;
import finalproject.models.serviceModels.*;
import finalproject.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    private final TownService townService;
    private final OfficeService officeService;
    private final ShipmentService shipmentService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SenderOrRecipientService senderOrRecipientService;


    public ShipmentController(TownService townService, OfficeService officeService, ShipmentService shipmentService, UserService userService, ModelMapper modelMapper, SenderOrRecipientService senderOrRecipientService) {
        this.townService = townService;
        this.officeService = officeService;
        this.shipmentService = shipmentService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.senderOrRecipientService = senderOrRecipientService;


    }


    @GetMapping("/add")
    public String addShipment(Model model) {

        model.addAttribute("towns", this.townService.findAllTowns());
        model.addAttribute("townsRec", this.townService.findAllTowns());

        if (!model.containsAttribute("shipmentAddBindingModel")) {
            model.addAttribute("shipmentAddBindingModel", new ShipmentAddBindingModel());
        }
        return "shipment-add";
    }


    @PostMapping("/add")
    public String postAddSender(@Valid @ModelAttribute("shipmentAddBindingModel") ShipmentAddBindingModel shipmentAddBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);
            return "redirect:add";
        } else {
            UserServiceModel userServiceModel =
                    this.userService.emailNotExist(shipmentAddBindingModel.getEmail());
            UserServiceModel userServiceModelRec =
                    this.userService.emailNotExist(shipmentAddBindingModel.getEmailRec());

            OfficeServiceModel officeSender = this.officeService.findById(shipmentAddBindingModel.getOffice());
            OfficeServiceModel officeRecipient = this.officeService.findById(shipmentAddBindingModel.getOfficeRec());


            if (userServiceModel == null || userServiceModelRec == null) {
                bindingResult.rejectValue("email", "email", "User not exist in Scorpio");

                redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
                redirectAttributes.addFlashAttribute
                        ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);

                return "redirect:add";
            } else if (officeSender == null || officeRecipient == null) {
                bindingResult.rejectValue("office", "office", "Office is invalid");

                redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
                redirectAttributes.addFlashAttribute
                        ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);

                return "redirect:add";
            } else {

                SenderOrRecipientServiceModel senderModel = getSender(officeSender, shipmentAddBindingModel.getEmail(), shipmentAddBindingModel.getTelephoneNumber(), shipmentAddBindingModel.getFirstName(), shipmentAddBindingModel.getLastName(), true);
                SenderOrRecipientServiceModel recipientModel = getRecipient(officeRecipient, shipmentAddBindingModel.getEmailRec(), shipmentAddBindingModel.getTelephoneNumberRec(), shipmentAddBindingModel.getFirstNameRec(), shipmentAddBindingModel.getLastNameRec(), false);

                this.shipmentService.addSender(this.modelMapper.map(shipmentAddBindingModel, ShipmentServiceModel.class), senderModel, recipientModel);

                return "redirect:/home";
            }

        }
    }

    private SenderOrRecipientServiceModel getRecipient(OfficeServiceModel officeRecipient, String emailRec, String telephoneNumberRec, String firstNameRec, String lastNameRec, boolean b) {
        SenderOrRecipientServiceModel recipientModel = new SenderOrRecipientServiceModel();
        recipientModel.setEmail(emailRec);
        recipientModel.setTelephoneNumber(telephoneNumberRec);
        recipientModel.setFirstName(firstNameRec);
        recipientModel.setLastName(lastNameRec);
        recipientModel.setOffice(officeRecipient);
        recipientModel.setSender(b);
        return recipientModel;
    }

    private SenderOrRecipientServiceModel getSender(OfficeServiceModel officeSender, String email, String telephoneNumber, String firstName, String lastName, boolean b) {
        SenderOrRecipientServiceModel senderModel = getRecipient(officeSender, email, telephoneNumber, firstName, lastName, b);
        return senderModel;
    }

}