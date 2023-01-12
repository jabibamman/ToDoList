import com.todolist.todolist.PasswordsException;
import com.todolist.todolist.User;
import com.todolist.todolist.ValidationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito.*;

public class UserTest {
    //mock setup
    @BeforeEach
    public void setup() {
        User user = mock(User.class);
        /*
        when(user.getFname()).thenReturn("John");
        when(user.getLname()).thenReturn("Doe");
        when(user.getEmail()).thenReturn("james@gmail.com");
        when(user.getBirthDate()).thenReturn(LocalDate.of(1999, 12, 12));
        when(user.getPassword()).thenReturn("123456789");

         */
    }

    @Test
    public void userWithValidDateIsValid() throws Exception {
        User user = mock(User.class);
        when(user.getBirthDate()).thenReturn(LocalDate.of(LocalDate.now().getYear() - 18, 12, 12));
        assertTrue(user.getBirthDate().isBefore(LocalDate.now()));
    }

    @Test()
    public void userWithInvalidDateIsInvalid() throws ValidationException {
        User user = mock(User.class);
        when(user.getBirthDate()).thenReturn(LocalDate.of(LocalDate.now().getYear() - 10, 12, 12));
        when(user.getBirthDate().isBefore(LocalDate.now().minusYears(13))).thenThrow(ValidationException.class);
    }

    @Test
    public void userWithInvalidEmailIsInvalid() {
        User user = new User("perezgmail.com", "Perez", "Jao", LocalDate.of(LocalDate.now().getYear() - 20, 1, 1), "Abcd1Azerty");
        assertThrows(ValidationException.class, user::isValid);
    }

    @Test
    public void userWithInvalidEmailIsValid() throws Exception {
        User user = new User("perez@gmail.com", "Perez", "Jao", LocalDate.of(LocalDate.now().getYear() - 20, 1, 1), "Abcd1Azerty");
        assertTrue(user.isValid());
    }

    @Test
    public void userWithEmptyNameIsInvalid() {
        User user = new User("perez@gmail.com", "", "Jao", LocalDate.of(LocalDate.now().getYear() - 20, 1, 1), "Abcd1Azerty");
        assertThrows(ValidationException.class, user::isValid);
    }

    @Test
    public void userWithEmptySurnameIsInvalid() {
        User user = new User("perez@gmail.com", "Perez", "", LocalDate.of(LocalDate.now().getYear() - 20, 1, 1), "Abcd1Azerty");
        assertThrows(ValidationException.class, user::isValid);
    }

    @Test
    public void userWithInvalidPassword() throws PasswordsException {
        User user = new User("s@gmail.com", "Perez", "Jao", LocalDate.of(LocalDate.now().getYear() - 20, 1, 1), "abbcd");
        assertThrows(PasswordsException.class, user::isValid);
    }
}
