package finalproject.services.impl;

import finalproject.errors.UserNotFoundException;
import finalproject.errors.UserRegisterException;
import finalproject.errors.UserToEmployee;
import finalproject.models.entities.*;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.repositories.UserRepository;
import finalproject.services.TownService;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final TownService townService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, TownService townService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;

        this.townService = townService;
    }



    @Override
    public UserServiceModel emailNotExist(String email) {
        return this.userRepository.findByEmail(email)
                .map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        if (this.emailNotExist(userServiceModel.getEmail()) != null) {

            throw new UserRegisterException();

        }
        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleUser);

        if (this.userRepository.count() == 0) {
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            Role roleEmployee = new Role();
            roleEmployee.setName("ROLE_EMPLOYEE");
            user.setRoles(List.of(roleAdmin, roleEmployee, roleUser));




        }
        this.userRepository.save(user);
    }


    @Override
    public User findByRole(String email,String role) {

        return this.userRepository.findByRole(email,role);
    }


    @Override
    public User saveUserRole(User user) {
        User updateUser = userRepository.findByEmail(user.getEmail()).orElseThrow(UserNotFoundException::new);

        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");

        if (this.userRepository.findByRole(updateUser.getEmail(), role.getName()) == null) {

            updateUser.getRoles().add(role);
        } else {
            throw new UserToEmployee();
        }
        return this.userRepository.save(updateUser);
    }

    @Override
    public boolean comparePasswords(String password, String password1) {

        if (passwordEncoder.matches(password1,password)) {
            return true;
        }
        return false;
    }

    @Override
    public void getOffice() {
        this.townService.saveAdminInOfficeAndEmployee();
    }

    @Override
    public User findAdminByRole(String role) {

        return this.userRepository.findByRole(role).orElse(null);
    }

}
