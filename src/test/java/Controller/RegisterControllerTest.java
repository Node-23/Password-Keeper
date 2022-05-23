package Controller;

import Service.Messages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterControllerTest {

    @Test
    void validUserPositiveTest() {
        String positiveAnswer = RegisterController.ValidUser(
                "Joaquim José",
                "joca123",
                "joca123"
        );
        assertEquals(Messages.loginSuccessMessage,positiveAnswer);
    }

    @Test
    void validUserPassNotMatchTest() {
        String answer = RegisterController.ValidUser(
                "Joaquim José",
                "joca123",
                "joao567"
        );
        assertEquals(Messages.passwordNotMatchErrorMessage,answer);
    }

    @Test
    void validUserLengthTest() {
        String answer = RegisterController.ValidUser(
                "Joaquim José",
                "joca",
                "joca"
        );
        assertEquals(Messages.fieldLengthErrorMessage,answer);
    }

    @Test
    void validUserAlreadyRegisteredUserTest() {
        String answer = RegisterController.ValidUser(
                "default",
                "default123",
                "default123"
        );
        assertEquals(Messages.usernameAlreadyExistsErrorMessage,answer);
    }

    @Test
    void UserAlreadyExistsPositiveTest() {
        boolean result = RegisterController.UserAlreadyExists("default");
        assertTrue(result);
    }

    @Test
    void UserAlreadyExistsNegativeTest() {
        boolean result = RegisterController.UserAlreadyExists("484884847578757");
        assertFalse(result);
    }
}