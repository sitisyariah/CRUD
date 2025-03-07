import java.sql.SQLOutput;
import java.util.Scanner;

public class Userinterface {

public static void tampilkanMenu() {
    System.out.println();
    System.out.println("+==============+");
    System.out.println("| Pilih menu:  |");
    System.out.println("+--------------+");
    System.out.println("| [C]  : Creat |");
    System.out.println("| [R]  : Read  |");
    System.out.println("| [U]  : Update|");
    System.out.println("| [D]  : Delete|");
    System.out.println("| [X]  : Exit  |");
    System.out.println("+==============+");
}
    public static void main(String[] args) {
        database db = new database();
        System.out.println("APLIKASI SIMPLE CRUD DATABASE");
        while (true) {
            tampilkanMenu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Pilih : ");
            String pilihan = sc.nextLine();
            pilihan = pilihan.toUpperCase();

            switch (pilihan) {
                case "C":
                    System.out.println("INFO: Anda memilih menu Create");
                    System.out.println("-------------------------------------");
                    System.out.println("INPUT DATA BARU");
                    System.out.print("NIM          : ");
                    String nim = sc.nextLine();
                    System.out.print("NAMA MAHASISWA : ");
                    String nama = sc.nextLine();
                    System.out.print("ALAMAT       : ");
                    String alamat = sc.nextLine();
                    System.out.print("SEMESTER      : ");
                    int semester = sc.nextInt();
                    System.out.print("SKS          : ");
                    int sks = sc.nextInt();
                    System.out.print("IPK          : ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("-----------------------------------------------------------");
                    boolean status = db.insert(nim, nama, alamat, semester, sks, ipk);
                    if (status == true) {
                        System.out.println("DATA BARU BERHASIL DITAMBAHKAN");
                    } else {
                        System.out.println("NIM " + nim + " sudah ada di database");
                        System.out.println("GAGAL MENAMBAHKAN DATA BARU");
                    }
                    System.out.println("INFO: Anda memilih menu Read");
                    break;
                case "R":
                    System.out.println("INFO: Anda memilih menu Read");
                    db.view();
                    break;
                case "U":
                    System.out.println("INFO: Anda memilih menu Update");
                    db.view();
                    System.out.print("Imput Key  (NIM Mahasiswa yang akan di Update): ");
                    String Key = sc.nextLine();
                    int index = db.search(Key);
                    if (index >= 0) {
                        System.out.println("Anda akan meng-update data " + db.getData().get(index));
                        System.out.println("---------------------------------------------------------");
                        System.out.println("INPUT DATA BARU");
                        System.out.print("NIM            : ");
                        String nim1 = sc.nextLine();
                        System.out.print("NAMA MAHASISWA : ");
                        String nama1 = sc.nextLine();
                        System.out.print("ALAMAT         : ");
                        String alamat1 = sc.nextLine();
                        System.out.print("SEMESTER       : ");
                        int semester1 = sc.nextInt();
                        System.out.print("SKS            : ");
                        int sks1 = sc.nextInt();
                        System.out.print("IPK            : ");
                        double ipk1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("-----------------------------------------------------------");
                        status = db.update(index, nim1, nama1, alamat1, semester1, sks1, ipk1);
                        if (status == true) {
                            System.out.println("DATA BERHASIL DIPERBAHARUI");
                        } else {
                            System.err.println("GAGAL MEMPERBAHARUI");
                        }
                        System.out.println("-----------------------------------------");
                    } else {
                        System.err.print("Mahasiswa dengan NINM: " + Key + " tidak ada di database");
                    }
                    break;
                case "D":
                    System.out.println("INFO: Anda akan memilih menu Delete");
                    db.view();
                    System.out.println("input Key (NIM Mahasiswa yang akan dihapus)");
                    Key = sc.nextLine();
                    index = db.search(Key);
                    if (index >= 0) {
                        System.out.println("APAKAH ANDA YAKIN AKAN MENGHAPUS DATA " + db.getData().get(index) + "? Y/N");
                        System.out.print("Pilih: ");
                        pilihan = sc.nextLine();
                        if (pilihan.equalsIgnoreCase("Y")) {
                            System.out.println("DATA MAHASISWA TELAH DIHAPUS");
                            status = db.delete(index);
                        }
                    }else{
                        System.err.println("Mahasiswa dengan NIM : " + Key + " tidak ada di database");
                    }

                    break;
                case "X":
                    System.out.println("INFO: Anda memilih menu EXIT");
                    System.out.println("APAKAH ANDA YAKINN AKAN KELUAR DARI APLIKASI? Y/N");
                    System.out.print("Pilih : ");
                    pilihan = sc.nextLine();
                    if (pilihan.equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
                    break;
            }

        }
    }

}
