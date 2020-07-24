package finalproject.web;

import finalproject.models.bindings.ShipmentAddBindingModel;
import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.serviceModels.SenderOrRecipientServiceModel;
import finalproject.models.serviceModels.ShipmentServiceModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.services.SenderOrRecipientService;
import finalproject.services.ShipmentService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SenderOrRecipientService sender;

    public ShipmentController(ShipmentService shipmentService, UserService userService, ModelMapper modelMapper,  SenderOrRecipientService sender) {
        this.shipmentService = shipmentService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.sender = sender;

    }

    @GetMapping("/add")
    public String addShipment(Model model){
        model.addAttribute("ship",new ShipmentAddBindingModel());
        return "shipment-add";
    }

    @PostMapping("/add")
    public String postAddSender(@Valid @ModelAttribute("ship")ShipmentAddBindingModel shipmentAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            return "redirect:add";
        }else {
            UserServiceModel userServiceModel =
                    this.userService.emailNotExist(shipmentAddBindingModel.getEmail());

            if (userServiceModel==null){
                bindingResult.rejectValue("email","email","The user is not in register");

                return "redirect:add";
            }else {
                SenderOrRecipientServiceModel senderModel=new SenderOrRecipientServiceModel();
                senderModel.setEmail(shipmentAddBindingModel.getEmail());
                senderModel.setTelephoneNumber(shipmentAddBindingModel.getTelephoneNumber());
                senderModel.setFirstName(shipmentAddBindingModel.getFirstName());
                senderModel.setLastName(shipmentAddBindingModel.getLastName());
                senderModel.setSender(true);

                SenderOrRecipientServiceModel recipientModel=new SenderOrRecipientServiceModel();
                recipientModel.setEmail(shipmentAddBindingModel.getEmailRec());
                recipientModel.setTelephoneNumber(shipmentAddBindingModel.getTelephoneNumberRec());
                recipientModel.setFirstName(shipmentAddBindingModel.getFirstNameRec());
                recipientModel.setLastName(shipmentAddBindingModel.getLastNameRec());
                recipientModel.setSender(false);
                this.shipmentService.addSender(this.modelMapper.map(shipmentAddBindingModel,ShipmentServiceModel.class), senderModel,recipientModel);

                return "redirect:/home";
            }

        }
    }

}
