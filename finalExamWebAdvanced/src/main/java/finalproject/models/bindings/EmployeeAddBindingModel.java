package finalproject.models.bindings;

import finalproject.models.entities.Office;
import finalproject.models.entities.Position;
import finalproject.models.entities.Town;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeAddBindingModel {

    private String email;
    private String town;
    private String office;
    private Position position;

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    public String getEmail() {
        return email;
    }

    public EmployeeAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeAddBindingModel setTown(String town) {
        this.town = town;
        return this;
    }

    public EmployeeAddBindingModel setPosition(Position position) {
        this.position = position;
        return this;
    }

    public String getOffice() {
        return office;
    }

    public EmployeeAddBindingModel setOffice(String office) {
        this.office = office;
        return this;
    }

    public String getTown() {
        return town;
    }

    @Enumerated(EnumType.STRING)
    public Position getPosition() {
        return position;
    }
}
