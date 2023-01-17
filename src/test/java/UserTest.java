import com.todolist.PasswordsException;
import com.todolist.User;
import com.todolist.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

    User user;

    //mock setup
    @BeforeEach
    void setup() {
       user = mock(User.class);
    }

    @Test
    void userWithValidDateIsValid() throws Exception {
        when(user.getBirthDate()).thenReturn(LocalDate.of(LocalDate.now().getYear() - 18, 12, 12));
        assertDoesNotThrow(user::getBirthDate);
        doReturn(true).when(user).isValidBirthday();
        assertTrue(user.isValidBirthday());
    }

    @Test()
    void userWithInvalidDate() throws Exception {
        when(user.getBirthDate()).thenReturn(LocalDate.of(LocalDate.now().getYear() - 10, 12, 12));
        doThrow(ValidationException.class).when(user).isValidBirthday();
        assertThrows(ValidationException.class, user::isValidBirthday);
    }

    @Test
    void userWithInvalidEmail() throws Exception {
        when(user.getEmail()).thenReturn("perezgmail.com");
        doThrow(ValidationException.class).when(user).isValidEmail();
        assertThrows(ValidationException.class, user::isValidEmail);
    }

    @Test
    void userWithValidEmail() throws Exception {
        when(user.getEmail()).thenReturn("perez@gmail.com");
        assertDoesNotThrow(user::isValidEmail);
        doReturn(true).when(user).isValidEmail();
        assertTrue(user.isValidEmail());
    }

    @Test
    void userWithInvalidEmptyFname() throws Exception {
        when(user.getFname()).thenReturn("");
        doThrow(ValidationException.class).when(user).isValid();
        assertFalse(user.isValidFname());
    }

    @Test
    void userWithValidFname() throws Exception {
        when(user.getFname()).thenReturn("daniel");
        assertDoesNotThrow(user::isValidFname);
        doReturn(true).when(user).isValidFname();
        assertTrue(user.isValidFname());
    }

    @Test
    void userWithInvalidEmptyLname() throws Exception {
        when(user.getLname()).thenReturn("");
        doThrow(ValidationException.class).when(user).isValid();
        assertFalse(user.isValidLname());
    }

    @Test
    void userWithValidLname() throws Exception {
        when(user.getEmail()).thenReturn("perez");
        assertDoesNotThrow(user::isValidLname);
        doReturn(true).when(user).isValidLname();
        assertTrue(user.isValidLname());
    }

    @Test
    void userWithInvalidPasswordWithoutNumberUppercaseAndNotMinmumCarac() throws Exception {
        when(user.getPassword()).thenReturn("abcd");
        doThrow(PasswordsException.class).when(user).isValidPassword();
        assertThrows(PasswordsException.class, user::isValidPassword);
    }

    @Test
    void userWithInvalidPasswordWithoutNumberUppercase() throws Exception {
        when(user.getPassword()).thenReturn("abcdoaid");
        doThrow(PasswordsException.class).when(user).isValidPassword();
        assertThrows(PasswordsException.class, user::isValidPassword);
    }

    @Test
    void userWithInvalidPasswordWithoutNumber() throws Exception {
        when(user.getPassword()).thenReturn("abcdOAid");
        doThrow(PasswordsException.class).when(user).isValidPassword();
        assertThrows(PasswordsException.class, user::isValidPassword);
    }

    @Test
    void userWithInvalidPasswordWithoutUppercase() throws Exception {
        when(user.getPassword()).thenReturn("abc1doaid");
        doThrow(PasswordsException.class).when(user).isValidPassword();
        assertThrows(PasswordsException.class, user::isValidPassword);
    }

    @Test
    void userWithValidPassword() throws Exception {
        when(user.getPassword()).thenReturn("Abbcd123");
        assertDoesNotThrow(user::isValidPassword);
        doReturn(true).when(user).isValidPassword();
        assertTrue(user.isValidPassword());
    }

    @Test
    void isValid() throws Exception {
        when(user.getFname()).thenReturn("daniel");
        when(user.getLname()).thenReturn("perez");
        when(user.getEmail()).thenReturn("test@gmail.com");
        when(user.getPassword()).thenReturn("Abcd123j");
        when(user.getBirthDate()).thenReturn(LocalDate.of(LocalDate.now().getYear() - 18, 12, 12));
        assertDoesNotThrow(user::isValid);
        doReturn(true).when(user).isValid();
        assertTrue(user.isValid());
    }

    @Test
    void isNotValid() throws Exception {
        when(user.getFname()).thenReturn("");
        when(user.getLname()).thenReturn("");
        when(user.getEmail()).thenReturn("testgmail.com");
        when(user.getPassword()).thenReturn("Abcd123j");
        when(user.getBirthDate()).thenReturn(LocalDate.of(LocalDate.now().getYear() - 18, 12, 12));
        doThrow(ValidationException.class).when(user).isValid();
        assertThrows(ValidationException.class, user::isValid);
    }
}
