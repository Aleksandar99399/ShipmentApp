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


    @OneToMany(cascade = CascadeType.ALL)
    public List<SenderOrRecipient> getSenderOrRecipients() {
        return senderOrRecipients;
    }

    public Shipment setSenderOrRecipients(List<SenderOrRecipient> senderOrRecipients) {
        this.senderOrRecipients = senderOrRecipients;
        return this;
    }

}
