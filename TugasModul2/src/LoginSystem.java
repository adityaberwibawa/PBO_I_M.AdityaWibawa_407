import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pilihanLogin;
        Admin admin1 = new Admin();
        Mahasiswa mahasiswa1 = new Mahasiswa();

        admin1.usernameAdmin = "Admin407";
        admin1.passwordAdmin = "Password407";

        mahasiswa1.nama = "Muhammad Aditya Wibawa";
        mahasiswa1.nim = "202410370110407";

        System.out.println("Login sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("masukkan pilihan (1/2): ");
        pilihanLogin = input.nextInt();
        input.nextLine();

        switch (pilihanLogin){
            case 1:
                admin1.login();
                break;
            case 2:
                mahasiswa1.login();
                break;
            default:
                System.out.println("Pilihan invalid!");
                break;
        }
    }
}
