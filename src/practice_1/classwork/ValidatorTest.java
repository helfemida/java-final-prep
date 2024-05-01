package practice_1.classwork;

import java.util.Scanner;

public class ValidatorTest {

    public void validatePassword(String password) throws InvalidPasswordFormatException {
        if (password == null)
            throw new InvalidPasswordFormatException("password cannot be null");
        if (password.length() < 8 || password.length() > 16)
            throw new InvalidPasswordFormatException("The length should be between 8 and 16");
        if (!containsUpperAndLowerCases(password))
            throw new InvalidPasswordFormatException("Add uppercase and lowercase chars");
        if(!containsSpecialChars(password))
            throw new InvalidPasswordFormatException("Add special chars");
    }

    public boolean containsUpperAndLowerCases(String password) {
        //Didi909090
        /*
        c = D, upperCases = 1, lowers = 0;
        c = i, uppers = 1, lowers = 1;
        c = d, uppers = 1, lowers = 2;
        c = i, uppers = 1, lowers = 3;
         */

        int lowerCases = 0;
        int upperCases = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCases++;
            }
            if (Character.isLowerCase(c)) {
                lowerCases++;
            }
        }

        if (upperCases >= 1 && lowerCases >= 1) {
            return true;
        }
        return false;
    }

    public boolean containsSpecialChars(String password){
        if(password.contains("@")) return true;
        if(password.contains("#")) return true;
        if(password.contains("$")) return true;
        if(password.contains("_")) return true;
        return false;
    }
}

class InvalidPasswordFormatException extends Exception {
    public InvalidPasswordFormatException(String message) {
        super(message);
    }
}

class TestValidator{
    public static void main(String[] args) throws InvalidPasswordFormatException {
        Scanner in = new Scanner(System.in);
        ValidatorTest validator = new ValidatorTest();
        boolean b = true;

        String password;
        do {
            password = in.next();
            try {
                validator.validatePassword(password);
                b = false;
            } catch (InvalidPasswordFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while(b);

    }
}
