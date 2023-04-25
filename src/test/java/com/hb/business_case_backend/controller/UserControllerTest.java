package com.hb.business_case_backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.hb.business_case_backend.dto.UserDTO;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.service.UserService;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ModelMapper modelMapper;

    @ParameterizedTest
    @ValueSource(strings = { "admin@gmail.com" })
    void userByEmail(String userEmail) {

        User user = userService.getUserByEmail(userEmail);

        assertEquals("admin@gmail.com", user.getUserEmail());
        assertEquals("Admin", user.getUserFirstName());
        assertEquals("Admin", user.getUserLastName());
        assertEquals("ADMIN", user.getUserRole().getRoleName());

        UserDTO dto = modelMapper.map(user, UserDTO.class);

    }

    @Test
    void createNewUser() {

        User user = userService.createUser(
                "test@gmail.com",
                "test",
                "Toto",
                "LeGrand",
                null,
                null,
                null,
                null);

        assertEquals("test@gmail.com", user.getUserEmail());
        assertEquals("Toto", user.getUserFirstName());
        assertEquals("LeGrand", user.getUserLastName());
        assertEquals("USER", user.getUserRole().getRoleName());

    }

    @Test
    void deleteUser() {

        assertNull(userService.getUserByEmail("test@gmail.com"));

        User userBefore = userService.createUser(
                "test@gmail.com",
                "test",
                "Toto",
                "LeGrand",
                null,
                null,
                null,
                null);

        assertNotNull(userBefore);
        assertEquals("test@gmail.com", userBefore.getUserEmail());

        boolean result = userService.deleteUser(userBefore.getUserId());

        assertFalse(result);

    }

}
