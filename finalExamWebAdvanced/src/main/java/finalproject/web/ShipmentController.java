package finalproject.web;

import finalproject.models.bindings.ShipmentAddBindingModel;
import finalproject.models.entities.Office;
import finalproject.models.serviceModels.*;
import finalproject.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    private final SenderOrRecipientService sender;


    public ShipmentController(TownService townService, OfficeService officeService, ShipmentService shipmentService, UserService userService, ModelMapper modelMapper, SenderOrRecipientService sender) {
        this.townService = townService;
        this.officeService = officeService;
        this.shipmentService = shipmentService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.sender = sender;

    }


    @GetMapping("/add")
    public ModelAndView addShipment(){

        ModelAndView model=new ModelAndView();
        model.addObject("towns",this.townService.findAllTowns());
        model.addObject("townsRec",this.townService.findAllTowns());

        model.addObject("shipmentAddBindingModel",new ShipmentAddBindingModel());
        model.setViewName("shipment-add");
        return  model;
    }


    @PostMapping("/add")
    public String postAddSender(@Valid @ModelAttribute("shipmentAddBindingModel")ShipmentAddBindingModel shipmentAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                Model model){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);
            return "redirect:add";
        }else {
            UserServiceModel userServiceModel =
                    this.userService.emailNotExist(shipmentAddBindingModel.getEmail());
            UserServiceModel userServiceModelRec =
                    this.userService.emailNotExist(shipmentAddBindingModel.getEmailRec());

            OfficeServiceModel officeSender=this.officeService.findById(shipmentAddBindingModel.getOffice());
            OfficeServiceModel officeRecipient=this.officeService.findById(shipmentAddBindingModel.getOfficeRec());


            if (userServiceModel==null ||userServiceModelRec==null){
                bindingResult.rejectValue("email", "email","User not exist in Scorpio");

                redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
                redirectAttributes.addFlashAttribute
                        ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);

                return "redirect:add";
            }else if (officeSender==null || officeRecipient==null){
                bindingResult.rejectValue("office","office","Office is invalid");
                redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
                redirectAttributes.addFlashAttribute
                        ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);

                return "redirect:add";
            } else {

                SenderOrRecipientServiceModel senderModel=new SenderOrRecipientServiceModel();
                senderModel.setEmail(shipmentAddBindingModel.getEmail());
                senderModel.setTelephoneNumber(shipmentAddBindingModel.getTelephoneNumber());
                senderModel.setFirstName(shipmentAddBindingModel.getFirstName());
                senderModel.setLastName(shipmentAddBindingModel.getLastName());
                senderModel.setOffice(officeSender);
                senderModel.setSender(true);


                SenderOrRecipientServiceModel recipientModel=new SenderOrRecipientServiceModel();
                recipientModel.setEmail(shipmentAddBindingModel.getEmailRec());
                recipientModel.setTelephoneNumber(shipmentAddBindingModel.getTelephoneNumberRec());
                recipientModel.setFirstName(shipmentAddBindingModel.getFirstNameRec());
                recipientModel.setLastName(shipmentAddBindingModel.getLastNameRec());
                recipientModel.setOffice(officeRecipient);
                recipientModel.setSender(false);


                this.shipmentService.addSender(this.modelMapper.map(shipmentAddBindingModel,ShipmentServiceModel.class), senderModel,recipientModel);

                return "redirect:/home";
            }

        }
    }

}
