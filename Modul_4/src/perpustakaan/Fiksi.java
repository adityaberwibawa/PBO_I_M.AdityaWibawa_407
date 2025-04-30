package perpustakaan;


public class Fiksi extends Buku{
    public Fiksi (String judul, String penulis) {
        super(judul, penulis);
    }

    @Override
    public void displayInfo(){
        System.out.println("\n ==== Buku Fiksi ==== ");
        System.out.println("1. Judul   : " + judul);
        System.out.println("   Penulis : " + penulis);
        System.out.println("   Kategori: Fiksi\n");
    }

}
