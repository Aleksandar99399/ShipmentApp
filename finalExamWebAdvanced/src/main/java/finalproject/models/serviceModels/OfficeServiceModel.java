package finalproject.models.serviceModels;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Town;

import java.util.ArrayList;
import java.util.List;

public class OfficeServiceModel {
    private String name;

    private Town town;

    public String getName() {
        return name;
    }

    public OfficeServiceModel setName(String name) {
        this.name = name;
        return this;
    }


    public Town getTown() {
        return town;
    }

    public OfficeServiceModel setTown(Town town) {
        this.town = town;
        return this;
    }
}
