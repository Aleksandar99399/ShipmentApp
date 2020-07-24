package finalproject.services;

import finalproject.models.entities.Shipment;
import finalproject.models.serviceModels.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserServiceModel emailNotExist(String email);

    void register(UserServiceModel userServiceModel);

    void addShip(UserServiceModel userServiceModel);
}
