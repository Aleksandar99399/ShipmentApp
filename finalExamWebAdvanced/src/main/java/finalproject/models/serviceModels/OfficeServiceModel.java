package finalproject.models.serviceModels;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Town;

import java.util.ArrayList;
import java.util.List;

public class OfficeServiceModel {
    private String name;
    private List<Employee> employees=new ArrayList<>();
    private Town town;

    public String getName() {
        return name;
    }

    public OfficeServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public OfficeServiceModel setEmployees(List<Employee> employees) {
        this.employees = employees;
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
