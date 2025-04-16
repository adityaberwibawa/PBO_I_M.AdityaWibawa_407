public class User {
    private String nama;
    private String nim;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNim(){
        return nama;
    }

    public void setNim(){
        this.nim = nim;
    }

    public void login(){
        System.out.println("login sebagai user.");
    }

    public void displayInfo(){
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }

}
