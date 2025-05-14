import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class ManajemenStok {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("sodik", 10));
        daftarBarang.add(new Barang("Yossua", 2));
        int pilihan = 0;

        do {
            System.out.println("\nxxxxxxx Menuw xxxxxxx");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan semua Baarang");
            System.out.println("3. Kurangi stok barang");
            System.out.println("4. Kelar");
            System.out.print("masukkan pilihan: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    try {
                        System.out.print("Nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Stok awala: ");
                        int stok = scanner.nextInt();

                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("barang baru berhasil ditambahkan!!");
                    } catch (InputMismatchException e){
                        System.out.println("input stok harus berupa angkaa!!!");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("barang mboten wonten");
                    } else {
                        System.out.println("xxxxxxx Daftar Barang xxxxxxx");
                        for (int i = 0; i < daftarBarang.size(); i++){
                            Barang barang = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
                        }
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("%%%%%%% Daftar Barang (pilih untuk dikurangi) %%%%%%%");
                        for (int i = 0; i < daftarBarang.size(); i++){
                            Barang barang = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
                        }

                        System.out.print("Masukkan nomer indeks barang: ");
                        int index = scanner.nextInt();
                        System.out.print("Masukkan jumlah stok yg diambil: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        Barang barang = daftarBarang.get(index);
                        if (jumlah > barang.getStok()){
                            throw new StokTidakCukupException("Stok " + barang.getNama() + " hanya " + barang.getStok());
                        }

                        barang.setStok(barang.getStok()-jumlah);
                        System.out.println("Stok berhasil dikurangi..");

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("indeks barang tidak validd");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("keluar!");
                    break;
                default:
                    System.out.println("invalid.");
            }
        } while (pilihan != 4);
    }

}
