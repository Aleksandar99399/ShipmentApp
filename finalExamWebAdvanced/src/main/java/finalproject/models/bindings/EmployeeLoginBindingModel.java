package finalproject.models.bindings;

public class EmployeeLoginBindingModel {
    private String email;
    private String password;
    private String town;
    private String office;

    public EmployeeLoginBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public EmployeeLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmployeeLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getTown() {
        return town;
    }

    public EmployeeLoginBindingModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getOffice() {
        return office;
    }

    public EmployeeLoginBindingModel setOffice(String office) {
        this.office = office;
        return this;
    }
}
