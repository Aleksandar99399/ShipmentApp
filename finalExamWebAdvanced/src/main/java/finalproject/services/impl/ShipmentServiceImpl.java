package finalproject.services.impl;

import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.entities.Shipment;
import finalproject.models.serviceModels.SenderOrRecipientServiceModel;
import finalproject.models.serviceModels.ShipmentServiceModel;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.repositories.ShipmentRepository;
import finalproject.services.OfficeService;
import finalproject.services.ShipmentService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final OfficeService officeService;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, UserService userService, ModelMapper modelMapper, OfficeService officeService) {
        this.shipmentRepository = shipmentRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.officeService = officeService;
    }

    @Override
    public ShipmentServiceModel addSender(ShipmentServiceModel shipSerMod,
                                          SenderOrRecipientServiceModel sender, SenderOrRecipientServiceModel recipient) {
        Shipment shipment=this.modelMapper.map(shipSerMod,Shipment.class);

        SenderOrRecipient senderEnt = this.modelMapper.map(sender, SenderOrRecipient.class);
        SenderOrRecipient recipientEnt = this.modelMapper.map(recipient, SenderOrRecipient.class);


        shipment.setSenderOrRecipients(List.of(senderEnt,recipientEnt));
        this.shipmentRepository.save(shipment);

        return this.modelMapper.map(shipment,ShipmentServiceModel.class);
    }



    @Override
    public UserServiceModel addUser(UserServiceModel userServiceModel) {
        return null;
    }

    @Override
    public List<Shipment> findAllByRecipients(String email, boolean isSender) {

        return this.shipmentRepository.findAllByRecipients(email,isSender);
    }

//    @Override
//    public boolean findByEmail(String email) {
//        return this.shipmentRepository.(email);
//    }

//    @Override
//    public List<Shipment> allShipmentsOnUserRecipient(String email,boolean isSender) {
//        return this.shipmentRepository.findAllByEmailAndSender(email,isSender);
//    }

//    @Override
//    public List<Shipment> allShipmentsOnUser(UserServiceModel userServiceModel) {
//
//        return this.shipmentRepository.findByUser(this.modelMapper.map(userServiceModel,User.class));
//    }
}
