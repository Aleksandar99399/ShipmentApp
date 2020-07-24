package finalproject.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity{

    private User user;
    private Office office;
    private Position position;

    @OneToOne
    public User getUser() {
        return user;
    }

    public Employee setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne
    public Office getOffice() {
        return office;
    }

    public Employee setOffice(Office office) {
        this.office = office;
        return this;
    }

    @Enumerated
    public Position getPosition() {
        return position;
    }

    public Employee setPosition(Position position) {
        this.position = position;
        return this;
    }
}
