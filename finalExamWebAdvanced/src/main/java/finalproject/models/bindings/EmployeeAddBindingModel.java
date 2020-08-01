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
    private Town town;
    private Office office;
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

    @Enumerated(EnumType.STRING)
    public Town getTown() {
        return town;
    }

    public EmployeeAddBindingModel setTown(Town town) {
        this.town = town;
        return this;
    }

    public Office getOffice() {
        return office;
    }

    public EmployeeAddBindingModel setOffice(Office office) {
        this.office = office;
        return this;
    }

    @NotNull
    public Position getPosition() {
        return position;
    }

    public EmployeeAddBindingModel setPosition(Position position) {
        this.position = position;
        return this;
    }
}
