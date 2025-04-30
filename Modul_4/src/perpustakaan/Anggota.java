package perpustakaan;


public class Anggota implements Peminjaman {
    String nama;
    String idAnggota;


    public Anggota (String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " [" + idAnggota + "] meminjam buku: " + "'" + judul + "'");
    }

    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " [" + idAnggota + "] meminjam buku: " + "'" + judul + "'" + " selama " + durasi + " hari.");
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " [" + idAnggota + "] mengembalikan buku: '" + judul + "'");
    }

}
