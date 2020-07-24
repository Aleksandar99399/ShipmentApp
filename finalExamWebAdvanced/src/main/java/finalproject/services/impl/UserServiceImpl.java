package finalproject.services.impl;

import finalproject.models.entities.Role;
import finalproject.models.entities.Shipment;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.UserServiceModel;
import finalproject.repositories.UserRepository;
import finalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserServiceModel emailNotExist(String email) {
        return this.userRepository.findByEmail(email)
                .map(u->this.modelMapper.map(u,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        User user=this.modelMapper.map(userServiceModel,User.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        Role roleUser=new Role();
        roleUser.setName("ROLE_USER");

        if (this.userRepository.count()==0){
            Role roleAdmin=new Role();
            roleAdmin.setName("ROLE_ADMIN");
            Role roleEmployee=new Role();
            roleEmployee.setName("ROLE_EMPLOYEE");
            user.setRoles(List.of(roleAdmin,roleEmployee,roleUser));


        }else {
            Role simple=new Role();
            simple.setName("ROLE_USER");
            user.setRoles(List.of(simple));
        }
        this.userRepository.save(user);
    }

    @Override
    public void addShip(UserServiceModel userServiceModel) {
        User map = this.modelMapper.map(userServiceModel, User.class);
        this.userRepository.save(map);

    }



}