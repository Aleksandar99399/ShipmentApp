package finalproject.models.serviceModels;

import finalproject.models.entities.Office;
import finalproject.services.OfficeService;

public class SenderOrRecipientServiceModel extends BaseServiceModel{

    private boolean isSender;
    private OfficeServiceModel office;


    public boolean isSender() {
        return isSender;
    }

    public SenderOrRecipientServiceModel setSender(boolean sender) {
        isSender = sender;
        return this;
    }

    public OfficeServiceModel getOffice() {
        return office;
    }

    public SenderOrRecipientServiceModel setOffice(OfficeServiceModel office) {
        this.office = office;
        return this;
    }
}
