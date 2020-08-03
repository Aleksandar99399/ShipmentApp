package finalproject.services;

import finalproject.models.entities.User;
import finalproject.models.serviceModels.UserServiceModel;

public interface UserService {

    UserServiceModel emailNotExist(String email);

    void register(UserServiceModel userServiceModel);

    void addShip(UserServiceModel userServiceModel);

    User saveUserRole(User user);
}
