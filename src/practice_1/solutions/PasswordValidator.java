package practice_1.solutions;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;

        do {
            try {
                System.out.println("Введите пароль:");
                password = scanner.nextLine();
                validatePassword(password);
                System.out.println("Пароль подходит по всем критериям.");
            } catch (InvalidPasswordFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void validatePassword(String password) throws InvalidPasswordFormatException {
        if (password.length() < 8 || password.length() > 16) {
            throw new InvalidPasswordFormatException("Пароль должен содержать от 8 до 16 символов.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordFormatException("Пароль должен содержать хотя бы одну заглавную букву.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordFormatException("Пароль должен содержать хотя бы одну строчную букву.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordFormatException("Пароль должен содержать хотя бы одну цифру.");
        }
        if (!password.matches(".*[@/\\#$^*-!].*")) {
            throw new InvalidPasswordFormatException("Пароль должен содержать хотя бы один из специальных символов: / @ # $ ^ * - !");
        }
    }

    static class InvalidPasswordFormatException extends Exception {
        public InvalidPasswordFormatException(String message) {
            super(message);
        }
    }
}

