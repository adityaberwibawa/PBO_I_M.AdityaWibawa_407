import java.util.Scanner;

public class Admin extends User {
    private String username;
    private String password;

    public Admin (String username, String password){
        super("", "");
        this.username = username;
        this.password = password;
    }

    @Override
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String inUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inPassword = scanner.nextLine();

        if (this.username.equals(inUsername) && this.password.equals(inPassword)){
            displayInfo();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    @Override
    public void displayInfo(){
        System.out.println("Login sebagai Admin berhasil.");
        System.out.println("-----------------------------");
        System.out.println("Username: " + username);
    }

}
