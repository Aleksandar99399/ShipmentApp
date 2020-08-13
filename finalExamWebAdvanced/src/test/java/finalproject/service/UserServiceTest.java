package finalproject.service;


import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.UserServiceModel;

import finalproject.repositories.UserRepository;

import finalproject.services.TownService;
import finalproject.services.UserService;


import finalproject.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.springframework.test.util.AssertionErrors.assertEquals;


import java.util.List;
import java.util.Optional;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest  {

    private UserService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private TownService townService;

    @BeforeEach
    public void setUp() {
        serviceToTest = new UserServiceImpl(mockUserRepository,
                new ModelMapper(),
                new BCryptPasswordEncoder(),
                townService);
    }

    private User getUser() {
        User user = new User();

        user.setId("1");
        user.setEmail("divoto@abv.bg");
        user.setFirstName("mock");
        user.setLastName("mockito");
        user.setTelephoneNumber("0893565689");
        user.setPassword("password");
        user.setRoles(List.of(new Role("ROLE_USER"), new Role("ROLE_EMPLOYEE"), new Role("ROLE_ADMIN")));

        return user;
    }

    @Test
    public void findUserByEmailCorrect() {
        //arrange
        User testUser = getUser();
        Mockito.when(this.mockUserRepository.findByEmail(testUser.getEmail())).thenReturn(Optional.of(testUser));

        //act
        UserServiceModel userServiceModel = this.serviceToTest.emailNotExist(testUser.getEmail());


        //assert
        Assertions.assertEquals(userServiceModel.getEmail(), testUser.getEmail());

//        //ARRANGE
//        Optional<User> byEmail = this.userRepository.findByEmail("divoto@abv.bg");
//
//
//           //ACT
//        UserServiceModel actual=this.userService.emailNotExist("divoto@abv.bg");
//
//        //ASSERT
//        assertTrue("yes",byEmail.isPresent());
    }
}