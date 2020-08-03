package finalproject.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shipments")
public class Shipment extends BaseEntity{

    private String description;
    private double weight;
    private BigDecimal price;
    private List<SenderOrRecipient> senderOrRecipients=new ArrayList<>();
    private List<Office> offices;




    @Length(min = 4,message = "Article should be more 4 characters")
    public String getDescription() {
        return description;
    }

    public Shipment setDescription(String article) {
        this.description = article;
        return this;
    }


    @Min(value = 0,message = "Weight cannot be negative number")
    public double getWeight() {
        return weight;
    }

    public Shipment setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @DecimalMin(value = "0",message = "Price cannot be negative number")
    public BigDecimal getPrice() {
        return price;
    }

    public Shipment setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    //    public String getFirstName() {
//        return firstName;
//    }
//
//    public Shipment setFirstName(String firstName) {
//        this.firstName = firstName;
//        return this;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public Shipment setLastName(String lastName) {
//        this.lastName = lastName;
//        return this;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Shipment setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public String getTelephoneNumber() {
//        return telephoneNumber;
//    }
//
//    public Shipment setTelephoneNumber(String telephoneNumber) {
//        this.telephoneNumber = telephoneNumber;
//        return this;
//    }
//
//
//    public boolean isSender() {
//        return isSender;
//    }
//
//    public Shipment setSender(boolean sender) {
//        isSender = sender;
//        return this;
//    }



    @OneToMany(cascade = CascadeType.ALL)
    public List<SenderOrRecipient> getSenderOrRecipients() {
        return senderOrRecipients;
    }

    public Shipment setSenderOrRecipients(List<SenderOrRecipient> senderOrRecipients) {
        this.senderOrRecipients = senderOrRecipients;
        return this;
    }

    @ManyToMany
    public List<Office> getOffices() {
        return offices;
    }

    public Shipment setOffices(List<Office> offices) {
        this.offices = offices;
        return this;
    }
}
