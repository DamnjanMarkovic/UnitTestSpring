package com.damnjan.restapitest;

import com.damnjan.restapitest.controllers.UserController;
import com.damnjan.restapitest.entity.User;
import com.damnjan.restapitest.repository.UserRepository;
import com.damnjan.restapitest.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserRepository userRepository;
    @MockBean
    private UserService userService;

    public UserControllerTest(UserController userController) {
        this.userController = userController;
    }

    @Test
    public void getUserByIDTest() throws Exception {
        //mock the data return by userService

        User user = new User();
        user.setName("John");
        user.setSalary("puno");
        user.setTeamName("ime tima");
//        user.setEmail("john@email.com");
//        user.setPhoneNumber("9778948856");
//        user.setGender("Male");

        when(userService.getUserbyID(ArgumentMatchers.anyInt())).thenReturn(user);
        //create a mock HTTP request to verify the expected result
        System.out.println("nesto");
        mockMvc.perform(MockMvcRequestBuilders.get("/user/12"))
                .andExpect(MockMvcResultMatchers.jsonPath("$name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$salary").value("puno"))
                .andExpect(MockMvcResultMatchers.jsonPath("$teamName").value("ime tima"))
//                .andExpect(MockMvcResultMatchers.jsonPath("email").value("john@email.com"))
//                .andExpect(MockMvcResultMatchers.jsonPath("gender").value("Male"))
//                .andExpect(MockMvcResultMatchers.jsonPath("phoneNumber").value("9778948856"))
                .andExpect(status().isOk());


    }
}
