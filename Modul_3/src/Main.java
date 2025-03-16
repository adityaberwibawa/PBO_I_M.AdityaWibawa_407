public class Main {
    public static void main(String[] args){
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum",100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + "  - memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + "      - memiliki kesehatan: " + viper.getKesehatan());

        System.out.println("\nPertarungan:");
        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
