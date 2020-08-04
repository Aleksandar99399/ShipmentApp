package finalproject.models.serviceModels;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Town;

import java.util.ArrayList;
import java.util.List;

public class OfficeServiceModel extends BaseServiceModel{
    private String name;

    private String town;

    public String getName() {
        return name;
    }

    public OfficeServiceModel setName(String name) {
        this.name = name;
        return this;
    }


    public String getTown() {
        return town;
    }

    public OfficeServiceModel setTown(String town) {
        this.town = town;
        return this;
    }
}
