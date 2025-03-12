import java.util.Scanner;

public class RekeningBank {
    Scanner input = new Scanner(System.in);
    String nomorRekening;
    String namaPemilik;
    Double saldo;

    void tampilkanInfo(){
        System.out.println("\nNomor Rekening: "+nomorRekening);
        System.out.println("Nama Pemilik  : "+namaPemilik);
        System.out.println("Saldo         : "+saldo+"\n");
    }
    void setorUang(double jumlah){
        saldo += jumlah;
        System.out.println(namaPemilik+" menyetor Rp."+jumlah+". Sakdo sekarang: "+saldo);
    }
    void  tarikUang(double jumlah){

        if (saldo >= jumlah){
            saldo -= jumlah;
            System.out.println(namaPemilik+" menarik Rp."+jumlah+". (Berhasil) Saldo saat ini: Rp."+saldo);
        } else {
            System.out.println(namaPemilik+" menarik Rp."+jumlah+". (Gagal, saldo tidak mencukupi) Saldo saat ini: Rp."+saldo);
        }
    }
}
