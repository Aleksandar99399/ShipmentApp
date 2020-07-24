package finalproject.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office extends BaseEntity{

    private String name;
    private List<Employee> employees=new ArrayList<>();
    private Town town;

    @Enumerated(EnumType.STRING)
    public Town getTown() {
        return town;
    }

    public Office setTown(Town town) {
        this.town = town;
        return this;
    }

    @Length(min = 4,message = "Office name should be more 3 characters")
    public String getName() {
        return name;
    }

    public Office setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany
    public List<Employee> getEmployees() {
        return employees;
    }

    public Office setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
