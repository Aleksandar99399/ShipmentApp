package finalproject.services;

import finalproject.models.entities.Role;
import finalproject.models.entities.User;

public interface RoleService {

    Role findByName(String role);
}
