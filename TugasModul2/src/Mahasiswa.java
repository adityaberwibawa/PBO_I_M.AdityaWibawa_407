import java.util.Scanner;

public class Mahasiswa {
    Scanner input = new Scanner(System.in);
    String nama;
    String nim;
    String inNama;
    String inNim;

    void login(){
        System.out.print("Masukkan nama: ");
        inNama = input.nextLine();
        System.out.print("Masukkan nim : ");
        inNim = input.nextLine();
        if (inNama.equalsIgnoreCase(nama) && inNim.equalsIgnoreCase(nim)){
            System.out.println("Login mahasiswa berhasil!");
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }
    void displayInfo(){
        if (inNama.equalsIgnoreCase(nama) && inNim.equalsIgnoreCase(nim)){
            System.out.println("\nNama : " + inNama);
            System.out.println("NIM  : " + inNim);
        } else {
            System.out.println();
        }
    }
}

