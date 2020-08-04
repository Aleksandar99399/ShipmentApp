package finalproject.models.serviceModels;

import finalproject.models.entities.Office;
import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.entities.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShipmentServiceModel extends BaseServiceModel{
    private String description;
    private double weight;
    private BigDecimal price;
    private List<SenderOrRecipient> senderOrRecipients=new ArrayList<>();

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

}
