package com.example.tugasmodul6.praktikum.main;

import com.example.tugasmodul6.praktikum.data.Data;
import com.example.tugasmodul6.praktikum.users.*;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("\n===== Sistem Login =====");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih role: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan == 1) {
                    loginMahasiswa(scanner);
                } else if (pilihan == 2) {
                    loginAdmin(scanner);
                } else if (pilihan == 3) {
                    System.out.println("Program selesai.");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void loginMahasiswa(Scanner scanner) {
        System.out.println("\n===== LOGIN MAHASISWA =====");
        System.out.print("Nama: ");
        String username = scanner.nextLine();
        System.out.print("NIM: ");
        String password = scanner.nextLine();

        for (User user : Data.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getUsername().equals(username) && mahasiswa.getPassword().equals(password)) {
                    mahasiswa.displayAppMenu();
                    return;
                }
            }
        }
        System.out.println("Login gagal! Nama atau NIM salah.");
    }

    private static void loginAdmin(Scanner scanner) {
        System.out.println("\n===== LOGIN ADMIN =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : Data.userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    admin.displayAppMenu();
                    return;
                }
            }
        }
        System.out.println("Login gagal! Username atau password salah.");
    }
}