import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Admin admin1 = new Admin("Admin407", "Password407");
        Mahasiswa mahasiswa1 = new Mahasiswa("Muhammad Aditya Wibawa", "202410370110407");

        System.out.println("Halaman login");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan login: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan){
            case 1:
                admin1.login();
                break;
            case 2:
                mahasiswa1.login();
                break;
            default:
                System.out.println("Pilihan invalid.");
                break;
        }

    }

}
