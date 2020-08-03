package finalproject.services;

import finalproject.models.entities.User;

public interface RoleService {
    void seedRoles();

    void addRole(User user);
}
