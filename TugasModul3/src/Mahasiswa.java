import java.util.Scanner;

public class Mahasiswa extends User {
    private String nama;
    private String nim;
    
    public Mahasiswa(String nama, String nim){
        super(nama, nim);
        this.nama = nama;
        this.nim = nim;
    }
    
    @Override
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String inNama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String inNim = scanner.nextLine();

        if (this.nama.equals(inNama) && this.nim.equals(inNim)){
            displayInfo();
        } else {
            System.out.println("Login gagal. nama atau nim salah.");
        }
    }

    @Override
    public void displayInfo(){
        System.out.println("Login sebagai Mahasiswa berhasil.");
        System.out.println("--------------------------------");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
    }

}
