package finalproject.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    private String name;

    @Column(name = "role",nullable = false)
    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Role() {
    }

    public Role(String name) {
        this.name=name;
    }
}
