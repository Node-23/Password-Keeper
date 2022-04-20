package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterControllerTest {

    @Test
    void validateUserDataPositiveTest() {
        boolean positiveAnswer = RegisterController.ValidateUserData(
                "Joaquim José",
                "joca123",
                "joca123"
        );
        assertTrue(positiveAnswer);
    }

    @Test
    void validateUserDataNegativeTest() {
        boolean positiveAnswer = RegisterController.ValidateUserData(
                "Joaquim José",
                "joca",
                "joca123"
        );
        assertFalse(positiveAnswer);
    }
}