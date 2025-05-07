package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User admin = new Admin("Admin407", "Password407");
        User mahasiswa = new Mahasiswa("Muhammad Aditya Wibawa", "202410370110407");

        System.out.println("Login Sebagai");

        System.out.println("===== LOGIN =====");
        System.out.print("Username/Nama: ");
        String username = scanner.nextLine();
        System.out.print("Password/NIM : ");
        String password = scanner.nextLine();

        User loggedInUser = null;

        if (admin.login(username, password)) {
            loggedInUser = admin;
        } else if (mahasiswa.login(username, password)) {
            loggedInUser = mahasiswa;
        }

        if (loggedInUser != null) {
            System.out.println("Login berhasil!\n");
            loggedInUser.displayAppMenu();
        } else {
            System.out.println("Login gagal! Username/nama atau password/nim salah.");
        }

    }

}