package finalproject.models.serviceModels;

import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.entities.User;

import java.math.BigDecimal;
import java.util.List;

public class ShipmentServiceModel {
    private String description;
    private double weight;
    private BigDecimal price;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String telephoneNumber;
//    private boolean isSender;
    private List<SenderOrRecipient> senderOrRecipients;

    public String getDescription() {
        return description;
    }

    public ShipmentServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }


    public double getWeight() {
        return weight;
    }

    public ShipmentServiceModel setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ShipmentServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public List<SenderOrRecipient> getSenderOrRecipients() {
        return senderOrRecipients;
    }

    public ShipmentServiceModel setSenderOrRecipients(List<SenderOrRecipient> senderOrRecipients) {
        this.senderOrRecipients = senderOrRecipients;
        return this;
    }

    //    public String getFirstName() {
//        return firstName;
//    }
//
//    public ShipmentServiceModel setFirstName(String firstName) {
//        this.firstName = firstName;
//        return this;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public ShipmentServiceModel setLastName(String lastName) {
//        this.lastName = lastName;
//        return this;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public ShipmentServiceModel setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public String getTelephoneNumber() {
//        return telephoneNumber;
//    }
//
//    public ShipmentServiceModel setTelephoneNumber(String telephoneNumber) {
//        this.telephoneNumber = telephoneNumber;
//        return this;
//    }
//
//    public boolean isSender() {
//        return isSender;
//    }
//
//    public ShipmentServiceModel setSender(boolean sender) {
//        isSender = sender;
//        return this;
//    }
}
