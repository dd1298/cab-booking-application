package org.dev.diptesh.cab_booking_application;

import org.dev.diptesh.cab_booking_application.Controllers.UserController;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.UserRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.UserResponseSignUpDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddUserTestCase {

    @Autowired
    private UserController userController;

    @Test
    public void testAddUser() {
        // Arrange
        UserRequestSignUpDto testUser = new UserRequestSignUpDto();
        testUser.setFirstName("Test");
        testUser.setLastName("User");
        testUser.setEmail("testuser@example.com");

        // Act
        ResponseEntity<?> returnedUser = userController.createUser(testUser);

        // Assert
        assertEquals(HttpStatus.CREATED, returnedUser.getStatusCode());
        assertTrue(returnedUser.getBody().toString().contains("User Added Successfully"));
    }
}