package finalproject.services.impl;

import finalproject.models.entities.Role;
import finalproject.repositories.RoleRepository;
import finalproject.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findByName(String role) {

        return this.roleRepository.findByName(role).orElse(null);
    }
}
