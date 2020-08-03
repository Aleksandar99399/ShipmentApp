package finalproject.models.bindings;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.entities.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ShipmentAddBindingModel {
    private String telephoneNumber;
    private String email;
    private String firstName;
    private String lastName;
    private double weight;
    private BigDecimal price;
    private String description;
    private String town;
    private String office;
    private String telephoneNumberRec;
    private String emailRec;
    private String firstNameRec;
    private String lastNameRec;
    private String  townRec;
    private String officeRec;

    @Pattern(regexp = "^[0-9\\-\\+]{10}$",message = "Enter valid telephone number")
    @NotNull
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public ShipmentAddBindingModel setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    public String getEmail() {
        return email;
    }

    public ShipmentAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Length(min = 3,message = "Name should be more than 2 characters")
    public String getFirstName() {
        return firstName;
    }

    public ShipmentAddBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Length(min = 3,message = "Name should be more than 2 characters")
    public String getLastName() {
        return lastName;
    }

    public ShipmentAddBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Min(value = 0,message = "Weight cannot be negative number")
    public double getWeight() {
        return weight;
    }

    public ShipmentAddBindingModel setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @DecimalMin(value = "0",message = "Price cannot be negative number")
    public BigDecimal getPrice() {
        return price;
    }

    public ShipmentAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Length(min = 4,message = "Article should be more 4 characters")
    public String getDescription() {
        return description;
    }

    public ShipmentAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTown() {
        return town;
    }

    public ShipmentAddBindingModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getOffice() {
        return office;
    }

    public ShipmentAddBindingModel setOffice(String office) {
        this.office = office;
        return this;
    }

    @Pattern(regexp = "^[0-9\\-\\+]{10}$",message = "Enter valid telephone number")
    @NotNull
    public String getTelephoneNumberRec() {
        return telephoneNumberRec;
    }

    public ShipmentAddBindingModel setTelephoneNumberRec(String telephoneNumberRec) {
        this.telephoneNumberRec = telephoneNumberRec;
        return this;
    }

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    public String getEmailRec() {
        return emailRec;
    }

    public ShipmentAddBindingModel setEmailRec(String emailRec) {
        this.emailRec = emailRec;
        return this;
    }
    @Length(min = 3,message = "Name should be more than 2 characters")
    public String getFirstNameRec() {
        return firstNameRec;
    }

    public ShipmentAddBindingModel setFirstNameRec(String firstNameRec) {
        this.firstNameRec = firstNameRec;
        return this;
    }
    @Length(min = 3,message = "Name should be more than 2 characters")
    public String getLastNameRec() {
        return lastNameRec;
    }

    public ShipmentAddBindingModel setLastNameRec(String lastNameRec) {
        this.lastNameRec = lastNameRec;
        return this;
    }

    public String getTownRec() {
        return townRec;
    }

    public ShipmentAddBindingModel setTownRec(String townRec) {
        this.townRec = townRec;
        return this;
    }

    public String getOfficeRec() {
        return officeRec;
    }

    public ShipmentAddBindingModel setOfficeRec(String officeRec) {
        this.officeRec = officeRec;
        return this;
    }
}
