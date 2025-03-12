public class Main {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        hewan1.Nama = "hewan1";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        hewan2.Nama = "hewan2";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Woof-Woof!!";

        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}