public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110407";
        rekening1.namaPemilik = "Muhammad Aditya Wibawa";
        rekening1.saldo = 7000000.00;

        rekening2.nomorRekening = "202410370110391";
        rekening2.namaPemilik = "Yossua Pujon";
        rekening2.saldo = 7000000.00;

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(100000.00);
        rekening2.setorUang(100000.00);
        rekening1.tarikUang(8000000.00);
        rekening1.tarikUang(7000000.00);
        rekening2.tarikUang(8000000.00);
        rekening2.tarikUang(7000000.00);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

    }
}