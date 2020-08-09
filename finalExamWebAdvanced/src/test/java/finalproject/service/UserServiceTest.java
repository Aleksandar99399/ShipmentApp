package finalproject.service;


import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.UserServiceModel;

import finalproject.repositories.UserRepository;

import finalproject.services.UserService;


import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.util.AssertionErrors.assertEquals;


import java.util.List;
import java.util.Optional;


public class UserServiceTest  {


    @Autowired
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @AfterEach
    public void delete() {
        this.userRepository.deleteAll();
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
        User user = getUser();

        Mockito.when(this.userRepository.findByEmail("divoto@abv.bg")).thenReturn(Optional.of(user));

        //act
        UserServiceModel userServiceModel = this.userService.emailNotExist("divoto@abv.bg");


        //assert
        assertEquals("yes", userServiceModel.getEmail(), user.getEmail());

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
