package finalproject.models.serviceModels;

import finalproject.models.entities.Position;
import finalproject.models.entities.Role;
import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.entities.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserServiceModel extends BaseServiceModel{
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String password;
    private List<Role> roles;

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public UserServiceModel setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }


}
