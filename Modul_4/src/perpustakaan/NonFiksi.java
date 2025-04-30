package perpustakaan;


public class NonFiksi extends Buku {
    public NonFiksi (String judul, String penulis) {
        super(judul, penulis);
    }

    @Override
    public void displayInfo(){
        System.out.println("\n ==== Buku NonFiksi ==== ");
        System.out.println("1. Judul   : " + judul);
        System.out.println("   Penulis : " + penulis);
        System.out.println("   Kategori: NonFiksi\n");
    }

}
