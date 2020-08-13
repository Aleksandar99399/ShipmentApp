package finalproject.controller;

import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    public void setUp() {

        //userRepository.deleteAll();

        User user = new User();

        Role roleUser = new Role("ROLE_USER");

        Role roleAdmin = new Role("ROLE_ADMIN");

        Role roleEmployee = new Role("ROLE_EMPLOYEE");

        user.setRoles(List.of(roleEmployee, roleAdmin, roleUser));

        user.setId("1");
        user.setEmail("sando@abv.bg");
        user.setPassword("1234");
        user.setTelephoneNumber("0896811826");
        user.setFirstName("Sando");
        user.setLastName("Kan");
        this.userRepository.save(user);

    }

    @AfterEach
    public void setDown() {
//        this.userRepository.deleteAll();
    }


    @Test
    public void should_Return_Register_Page() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("userRegisterBindingModel"));
    }

}

