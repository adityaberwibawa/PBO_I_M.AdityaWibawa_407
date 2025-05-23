package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Data;
import com.praktikum.data.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        reportItem(scanner);
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 3:
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = 0;
            }
        } while (pilihan != 3);
    }

    @Override
    public void reportItem(Scanner scanner) {
        System.out.println("\n=== Laporkan Barang ===");
        System.out.print("Nama barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Deskripsi barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi terakhir ditemukan: ");
        String lokasi = scanner.nextLine();

        Item newItem = new Item(namaBarang, deskripsi, lokasi, "Reported");
        Data.reportedItems.add(newItem);

        System.out.println("\nLaporan berhasil dibuat untuk:");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
    }

    @Override
    public void viewReportedItems() {
        if (Data.reportedItems.isEmpty()) {
            System.out.println("\nBelum ada laporan barang.");
            return;
        }

        System.out.println("\n=== Daftar Barang yang Dilaporkan ===");
        for (Item item : Data.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                System.out.println("Nama: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("---------------------");
            }
        }
    }
}