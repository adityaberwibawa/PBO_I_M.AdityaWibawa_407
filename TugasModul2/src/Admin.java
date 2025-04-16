import java.util.Scanner;

public class Admin {
    Scanner input = new Scanner(System.in);
    String usernameAdmin;
    String passwordAdmin;
    String inUsername;
    String inPassword;

    void login(){
        System.out.print("Masukkan username: ");
        inUsername = input.nextLine();
        System.out.print("Masukkan password: ");
        inPassword = input.nextLine();
        if (inUsername.equalsIgnoreCase(usernameAdmin) && inPassword.equalsIgnoreCase(passwordAdmin)) {
            System.out.print("Login admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}
