package finalproject.web;

import finalproject.errors.UserNotFoundException;
import finalproject.models.bindings.ShipmentAddBindingModel;
import finalproject.models.entities.Shipment;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.SenderOrRecipientServiceModel;
import finalproject.models.serviceModels.ShipmentServiceModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.services.OfficeService;
import finalproject.services.SenderOrRecipientService;
import finalproject.services.ShipmentService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    private final OfficeService officeService;
    private final ShipmentService shipmentService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SenderOrRecipientService sender;


    public ShipmentController(OfficeService officeService, ShipmentService shipmentService, UserService userService, ModelMapper modelMapper, SenderOrRecipientService sender) {
        this.officeService = officeService;
        this.shipmentService = shipmentService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.sender = sender;

    }


    @GetMapping("/add")
    public ModelAndView addShipment(){

        ModelAndView model=new ModelAndView();
        model.addObject("burgas",this.officeService.findAllOffices());
        model.addObject("shipmentAddBindingModel",new ShipmentAddBindingModel());
        model.setViewName("shipment-add");
        return  model;
    }


    @PostMapping("/add")
    public String postAddSender(@RequestParam(value = "officeName",required = false)String officeName,
                                @Valid @ModelAttribute("shipmentAddBindingModel")ShipmentAddBindingModel shipmentAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                Model model){
        String off=shipmentAddBindingModel.getOffice();

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

            if (userServiceModel==null ||userServiceModelRec==null){
                bindingResult.rejectValue("email", "email","User not exist in Scorpio");

                redirectAttributes.addFlashAttribute("shipmentAddBindingModel", shipmentAddBindingModel);
                redirectAttributes.addFlashAttribute
                        ("org.springframework.validation.BindingResult.shipmentAddBindingModel", bindingResult);

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
