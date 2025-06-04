package com.example.tugasmodul6.praktikum.users;

import com.example.tugasmodul6.praktikum.actions.AdminActions;
import com.example.tugasmodul6.praktikum.data.Data;
import com.example.tugasmodul6.praktikum.data.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
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
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Kelola Laporan Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("3. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        viewAllItems();
                        break;
                    case 2:
                        markItemAsClaimed(scanner);
                        break;
                    case 3:
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

    private void viewAllItems() {
        if (Data.reportedItems.isEmpty()) {
            System.out.println("\nBelum ada laporan barang.");
            return;
        }

        System.out.println("\n=== Daftar Semua Laporan ===");
        for (int i = 0; i < Data.reportedItems.size(); i++) {
            Item item = Data.reportedItems.get(i);
            System.out.printf("%d. Nama: %s | Deskripsi: %s | Lokasi: %s | Status: %s\n",
                    i + 1, item.getItemName(), item.getDescription(),
                    item.getLocation(), item.getStatus());
        }
    }

    private void markItemAsClaimed(Scanner scanner) {
        if (Data.reportedItems.isEmpty()) {
            System.out.println("\nBelum ada laporan barang.");
            return;
        }


        System.out.println("\n=== Daftar Barang yang Belum Diambil ===");
        for (int i = 0; i < Data.reportedItems.size(); i++) {
            Item item = Data.reportedItems.get(i);
            if ("Reported".equals(item.getStatus())) {
                System.out.printf("%d. Nama: %s | Lokasi: %s\n",
                        i + 1, item.getItemName(), item.getLocation());
            }
        }

        System.out.print("\nMasukkan nomor barang yang akan ditandai (0 untuk batal): ");
        try {
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index == -1) {
                return;
            }

            if (index >= 0 && index < Data.reportedItems.size()) {
                Item item = Data.reportedItems.get(index);
                if ("Reported".equals(item.getStatus())) {
                    item.setStatus("Claimed");
                    System.out.println("Barang '" + item.getItemName() + "' telah ditandai sebagai diambil.");
                } else {
                    System.out.println("Barang tersebut sudah ditandai sebelumnya.");
                }
            } else {
                System.out.println("Nomor barang tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Kelola Data Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        addMahasiswa(scanner);
                        break;
                    case 2:
                        removeMahasiswa(scanner);
                        break;
                    case 3:
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

    private void addMahasiswa(Scanner scanner) {
        System.out.println("\n=== Tambah Mahasiswa ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();

        Data.userList.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
    }

    private void removeMahasiswa(Scanner scanner) {
        System.out.println("\n=== Hapus Mahasiswa ===");
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        boolean found = false;
        for (User user : Data.userList) {
            if (user instanceof Mahasiswa && user.getPassword().equals(nim)) {
                Data.userList.remove(user);
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
}