package finalproject.services;

import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.serviceModels.SenderOrRecipientServiceModel;

import java.util.List;

public interface SenderOrRecipientService {

    boolean isExistSenderOrRecipient(String email);

    SenderOrRecipientServiceModel addSender(SenderOrRecipientServiceModel map);

    SenderOrRecipientServiceModel addRecipient(SenderOrRecipientServiceModel map);

    List<SenderOrRecipient> findAllBySender(boolean isSender);
}
