package finalproject.services;

import finalproject.models.entities.User;
import finalproject.models.serviceModels.UserServiceModel;

public interface UserService {

    UserServiceModel emailNotExist(String email);

    void register(UserServiceModel userServiceModel);

    User findByRole(String email,String role);

    User saveUserRole(User user);

    boolean comparePasswords(String password, String password1);

    void getOffice();

    User findAdminByRole(String role);
}
