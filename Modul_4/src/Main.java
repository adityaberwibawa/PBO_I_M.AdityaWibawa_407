import perpustakaan.*;


public class Main {
    public static void main (String[] args){
        int durasi = 7;

        Buku fiksi1 = new Fiksi("Cerita rakyat tentang kakikulukaka", "bude Yossua Ngibulan,A.Md.P");
        Buku nonFiksi1 = new NonFiksi("Teori lari di atas air mata kaki", "pakde Yossua,PH.D.");

        fiksi1.displayInfo();
        nonFiksi1.displayInfo();

        Anggota member1 = new Anggota("Bowo", "I407");
        Anggota member2 = new Anggota("Sodick", "I300");

        member1.pinjamBuku(fiksi1.getJudul());
        member2.pinjamBuku(nonFiksi1.getJudul(), durasi);

        member1.kembalikanBuku(fiksi1.getJudul());
        member2.kembalikanBuku(nonFiksi1.getJudul());
    }

}
