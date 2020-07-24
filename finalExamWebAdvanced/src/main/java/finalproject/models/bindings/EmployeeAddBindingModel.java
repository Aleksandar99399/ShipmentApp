package finalproject.models.bindings;

import finalproject.models.entities.Town;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class EmployeeAddBindingModel {

    private String email;
    private Town town;
    private String officeName;

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    public String getEmail() {
        return email;
    }

    public EmployeeAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Enumerated
    public Town getTown() {
        return town;
    }

    public EmployeeAddBindingModel setTown(Town town) {
        this.town = town;
        return this;
    }

    @Length(min = 4,message = "Office name should be more 3 characters")
    public String getOfficeName() {
        return officeName;
    }

    public EmployeeAddBindingModel setOfficeName(String officeName) {
        this.officeName = officeName;
        return this;
    }
}
