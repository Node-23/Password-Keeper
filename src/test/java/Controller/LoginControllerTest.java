package Controller;

import Model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    @Test
    void validateLoginPositiveTest() {
        User testUser = new User("default", "123456");
        boolean result = LoginController.ValidateLogin(testUser);
        assertTrue(result);
    }

    @Test
    void validateLoginNegativeTest() {
        User testUser = new User("NeverCreatedUser", "");
        boolean result = LoginController.ValidateLogin(testUser);
        assertFalse(result);
    }
}