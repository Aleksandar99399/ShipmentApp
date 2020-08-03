package finalproject.services.impl;

import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.repositories.UserRepository;
import finalproject.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {


    private final UserRepository userRepository;

    public RoleServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void seedRoles() {
    }

    @Override
    public void addRole(User user) {

        Role role =new Role("ROLE_EMPLOYEE");
        user.getRoles().add(role);

        userRepository.save(user);

    }
}
