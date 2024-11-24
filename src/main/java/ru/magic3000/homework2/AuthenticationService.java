package ru.magic3000.homework2;

import java.util.regex.Pattern;

public class AuthenticationService {
    private static final Pattern loginRegex = Pattern.compile("^[A-Za-z0-9_]{1,19}$");
    private static final Pattern passwordRegex = Pattern.compile("^[A-Za-z0-9_]{1,19}$");
    public static boolean login(String login, String password, String confirmPassword) {
        try
        {
            if (!loginRegex.matcher(login).matches()) {
                throw new WrongLoginException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Passwords do not match");
            }
            if (!passwordRegex.matcher(password).matches()) {
                throw new WrongPasswordException();
            }
            return true;
        }
        catch (WrongLoginException | WrongPasswordException e) {
            return false;
        }
    }
}
