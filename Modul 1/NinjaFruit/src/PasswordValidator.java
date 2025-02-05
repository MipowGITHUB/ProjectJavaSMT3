import java.util.Scanner;

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidator {
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password harus memiliki minimal 8 karakter.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf besar.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf kecil.");
        }

        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu angka.");
        }

        if (!password.matches(".*[!@#$%^&*].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter khusus (!@#$%^&*).");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan password (atau 'quit' untuk keluar): ");
            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                validatePassword(password);
                System.out.println("Password valid!");
                break;
            } catch (InvalidPasswordException e) {
                System.out.println("Password tidak valid: " + e.getMessage());
            }
        }

        scanner.close();
    }
}