package finalproject.models.serviceModels;

import finalproject.models.entities.Office;
import finalproject.models.entities.Position;
import finalproject.models.entities.User;

public class EmployeeServiceModel {
    private User user;
    private Office office;
    private Position position;

    public User getUser() {
        return user;
    }

    public EmployeeServiceModel setUser(User user) {
        this.user = user;
        return this;
    }

    public Office getOffice() {
        return office;
    }

    public EmployeeServiceModel setOffice(Office office) {
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
