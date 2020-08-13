package finalproject.models.serviceModels;

import finalproject.models.entities.Position;
import finalproject.models.entities.Role;
import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.entities.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserServiceModel extends BaseServiceModel{

    private String password;
    private List<Role> roles;


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