import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pilihanLogin;
        String usernameAdmin = "Admin407";
        String passwordAdmin = "Password407";
        String inUsername;
        String inPassword;
        String namaMhs = "Muhammad Aditya Wibawa";
        String nimMhs = "202410370110407";
        String inNamaMhs;
        String inNimMhs;

        System.out.println("Login sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("masukkan pilihan (1/2): ");
        pilihanLogin = scan.nextInt();
        scan.nextLine();

        if (pilihanLogin == 1) {
            System.out.print("Masukkan username: ");
            inUsername = scan.nextLine();
            System.out.print("Masukkan password: ");
            inPassword = scan.nextLine();

            if (inUsername.equalsIgnoreCase(usernameAdmin) && inPassword.equalsIgnoreCase(passwordAdmin)) {
                System.out.print("Login admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihanLogin == 2) {
            System.out.print("Masukkan Nama: ");
            inNamaMhs = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            inNimMhs = scan.nextLine();

            if (inNamaMhs.equalsIgnoreCase(namaMhs) && inNimMhs.equalsIgnoreCase(nimMhs)){
                System.out.println("Login mahasiswa berhasil!");
                System.out.println("Nama : " + inNamaMhs);
                System.out.println("NIM  : " + inNimMhs);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan invalid.");
        }
    }
}
