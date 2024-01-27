package view;

import java.util.Scanner;
import controler.*;

public class viewAdmin {
    static controlerAdmin controlerAdmin = new controlerAdmin();
    static Scanner in = new Scanner(System.in);

    public static void mianView() {
        while (true) {
            System.out.println("Selamat Datang");
            System.out.println("1. Tambah poli");
            System.out.println("2. Tambah jadwal praktek");
            System.out.println("3. Ubah jadwal praktek");
            System.out.println("4. lihat ditail transaksi");
            System.out.println("0. Kembali");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = in.nextInt();
            switch (pilihan) {
                case 1 -> addPoli();
                case 2 -> addJadwalPraktek();
                case 3 -> updateJadwalPraktek();
                case 4 -> controlerAdmin.viewALLTransaksi();
                case 0 -> view.mainView.viewMain();
                default -> System.out.println("input ERROR");
            }
        }
    }

    public static void addPoli(){
        in.nextLine();
        System.out.println("Masukan nama poli : ");
        String nama = in.nextLine();
        controlerAdmin.addPoli(nama);
    }

    public static void addJadwalPraktek(){
        in.nextLine();
        System.out.println("Masukan nama dokter : ");
        String nama = in.nextLine();
        System.out.println("Masukan hari : ");
        String hari = in.nextLine();
        System.out.println("Masukan jam : ");
        String jam = in.nextLine();
        controlerAdmin.addPraktek(nama, hari, jam);
    }

    public static void updateJadwalPraktek(){
        in.nextLine();
        System.out.println("Masukan id : ");
        int id = in.nextInt();
        System.out.println("Masukan nama dokter : ");
        String nama = in.nextLine();
        System.out.println("Msukan hari : ");
        String hari = in.nextLine();
        System.out.println("Masukan jam : ");
        String jam = in.nextLine();
        controlerAdmin.updatePraktek(id, nama, hari, jam);
    }
}
