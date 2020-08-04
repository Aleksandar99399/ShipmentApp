package finalproject.models.serviceModels;

import finalproject.models.entities.Office;
import finalproject.models.entities.Position;
import finalproject.models.entities.User;
import finalproject.services.OfficeService;

public class EmployeeServiceModel extends BaseServiceModel {
    private UserServiceModel user;
    private OfficeServiceModel office;
    private Position position;

    public EmployeeServiceModel() {
    }

    public UserServiceModel getUser() {
        return user;
    }

    public EmployeeServiceModel setUser(UserServiceModel user) {
        this.user = user;
        return this;
    }

    public OfficeServiceModel getOffice() {
        return office;
    }

    public EmployeeServiceModel setOffice(OfficeServiceModel office) {
        this.office = office;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public EmployeeServiceModel setPosition(Position position) {
        this.position = position;
        return this;
    }
}
