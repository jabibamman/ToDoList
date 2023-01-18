package com.todolist;

import com.todolist.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UserTest {

    User user;
    VerifyPassword verifyPassword;
    VerifyFname verifyFname;
    VerifyLname verifyLname;
    VerifyEmail verifyEmail;
    VerifyBirthDate verifyBirthDate;

    //mock setup
    @BeforeEach
    void setup() {
       user = mock(User.class);
       verifyPassword = mock(VerifyPassword.class);
       verifyFname = mock(VerifyFname.class);
       verifyLname = mock(VerifyLname.class);
       verifyEmail = mock(VerifyEmail.class);
       verifyBirthDate = mock(VerifyBirthDate.class);
    }

    @Test
    void userWithValidDateIsValid() throws Exception {
        LocalDate date = LocalDate.of(LocalDate.now().getYear() - 18, 12, 12);
        assertDoesNotThrow(() -> {
            verifyBirthDate.isValidStr(date);
        });
        doReturn(true).when(verifyBirthDate).isValidStr(date);
        assertTrue(verifyBirthDate.isValidStr(date));
    }

    @Test()
    void userWithInvalidDate() throws Exception {
        LocalDate date = LocalDate.of(LocalDate.now().getYear() - 10, 12, 12);
        doThrow(ValidationException.class).when(verifyBirthDate).isValidStr(date);
        assertThrows(ValidationException.class, () -> {
            verifyBirthDate.isValidStr(date);
        });
    }

    @Test
    void userWithInvalidEmail() throws Exception {
        String email = "perezgmail.com";
        doThrow(ValidationException.class).when(verifyEmail).isValidStr(email);
        assertThrows(ValidationException.class, () -> {
            verifyEmail.isValidStr(email);
        });
    }

    @Test
    void userWithValidEmail() throws Exception {
        String email = "perez@gmail.com";
        assertDoesNotThrow(() -> {
            verifyEmail.isValidStr(email);
        });
        doReturn(true).when(verifyEmail).isValidStr(email);
        assertTrue(verifyEmail.isValidStr(email));
    }

    @Test
    void userWithInvalidEmptyFname() throws Exception {
        String fname = "";
        doThrow(ValidationException.class).when(verifyFname).isValidStr(fname);
        assertThrows(ValidationException.class, () -> {
            verifyFname.isValidStr(fname);
        });
    }

    @Test
    void userWithValidFname() throws Exception {
        String fname = "Jean";
        assertDoesNotThrow(() -> {
            verifyFname.isValidStr(fname);
        });
        doReturn(true).when(verifyFname).isValidStr(fname);
        assertTrue(verifyFname.isValidStr(fname));
    }

    @Test
    void userWithInvalidEmptyLname() throws Exception {
        String lname = "";
        doThrow(ValidationException.class).when(verifyLname).isValidStr(lname);
        assertThrows(ValidationException.class, () -> {
            verifyLname.isValidStr(lname);
        });
    }

    @Test
    void userWithValidLname() throws Exception {
        String lname = "Perez";
        assertDoesNotThrow(() -> {
            verifyLname.isValidStr(lname);
        });
        doReturn(true).when(verifyLname).isValidStr(lname);
        assertTrue(verifyLname.isValidStr(lname));
    }

    @Test
    void userWithInvalidPasswordWithoutNumberUppercaseAndNotMinmumCarac() throws Exception {
        String password = "abcd";
        doThrow(PasswordsException.invalidLength()).when(verifyPassword).isValidStr(password);
        assertThrows(PasswordsException.class, () -> {
            verifyPassword.isValidStr(password);
        });
    }

    @Test
    void userWithInvalidPasswordWithoutNumberUppercase() throws Exception {
        String password = "abcd1234";
        doThrow(PasswordsException.noUpperCase()).when(verifyPassword).isValidStr(password);
        assertThrows(PasswordsException.class, () -> {
            verifyPassword.isValidStr(password);
        });
    }

    @Test
    void userWithInvalidPasswordWithoutNumber() throws Exception {
        String password = "abcdAid";
        doThrow(PasswordsException.noNumber()).when(verifyPassword).isValidStr(password);
        assertThrows(PasswordsException.class, () -> {
            verifyPassword.isValidStr(password);
        });
    }

    @Test
    void userWithInvalidPasswordWithoutUppercase() throws Exception {
        String password = "abcd1234";
        doThrow(PasswordsException.noUpperCase()).when(verifyPassword).isValidStr(password);
        assertThrows(PasswordsException.class, () -> {
            verifyPassword.isValidStr(password);
        });
    }

    @Test
    void userWithValidPassword() throws Exception {
        String password = "abcdA123";
        assertDoesNotThrow(() -> {
            verifyPassword.isValidStr(password);
        });
        doReturn(true).when(verifyPassword).isValidStr(password);
        assertTrue(verifyPassword.isValidStr(password));
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
