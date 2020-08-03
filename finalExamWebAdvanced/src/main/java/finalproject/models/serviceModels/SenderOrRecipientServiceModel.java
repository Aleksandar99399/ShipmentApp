package finalproject.models.serviceModels;

import finalproject.models.entities.Office;

public class SenderOrRecipientServiceModel {
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private boolean isSender;

    public String getFirstName() {
        return firstName;
    }

    public SenderOrRecipientServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SenderOrRecipientServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SenderOrRecipientServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public SenderOrRecipientServiceModel setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public boolean isSender() {
        return isSender;
    }

    public SenderOrRecipientServiceModel setSender(boolean sender) {
        isSender = sender;
        return this;
    }

}
