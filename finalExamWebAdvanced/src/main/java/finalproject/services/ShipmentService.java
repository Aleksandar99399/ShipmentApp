package finalproject.services;

import finalproject.models.entities.Office;
import finalproject.models.entities.Shipment;
import finalproject.models.serviceModels.SenderOrRecipientServiceModel;
import finalproject.models.serviceModels.ShipmentServiceModel;
import finalproject.models.serviceModels.UserServiceModel;

import java.util.List;

public interface ShipmentService {
    ShipmentServiceModel addSender(ShipmentServiceModel shipSerMod,
                                   SenderOrRecipientServiceModel sender, SenderOrRecipientServiceModel recipient);

    UserServiceModel addUser(UserServiceModel userServiceModel);

    List<Shipment>findAllByRecipients(boolean isSender,Office office);

    List<Shipment> findAllShipmentsOnUser(String email,boolean isSender);

}
