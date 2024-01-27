package view;

import controler.*;
import java.util.Scanner;

public class mainView {
    static controlerPasien controlerPasien = new controlerPasien();
    static controlerLogin controlerLogin = new controlerLogin();
    static controlerAdmin controlerAdmin = new controlerAdmin();
    static Scanner in = new Scanner(System.in);
    public static void viewMain() {
        while (true) {
            System.out.println("Selamat Datang");
            controlerAdmin.viewALLPraktek();
            System.out.println("1. Pasien baru");
            System.out.println("2. Ambil antrian");
            System.out.println("3. Login");
            System.out.println("0. Exit");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = in.nextInt();
            switch (pilihan) {
                case 1 -> addPasien();
                case 2 -> ambilAntrian();
                case 3 -> Login();
                case 0 -> System.exit(0);
                default -> System.out.println("input ERROR");
            }
        }
    }

    public static void addPasien(){
        System.out.println("Masukan nama pasien : ");
        in.nextLine();
        String nama = in.nextLine();
        System.out.println("Masukan alamat : ");
        String alamat = in.nextLine();
        System.out.println("Masukan kelamin(L/P) : ");
        String kelamin = in.nextLine();
        System.out.println("Masukan TTL(DD-MM-YYYY) : ");
        String ttl = in.nextLine();
        System.out.println("Masukan NIK : ");
        int nik = in.nextInt();
        System.out.println("Masukan nomer BPJS (JIKA ADA) : ");
        int bpjs = in.nextInt();
        controlerPasien.addPasien(nama, alamat, kelamin, ttl, nik, bpjs);
    }

    public static void ambilAntrian(){
        System.out.println("1. Masukan nik");
        System.out.println("2. Masukan nomer BPJS");
        System.out.print("masukan pilihan : ");
        int pilihan = in.nextInt();

        if (pilihan == 1) {
            System.out.print("Masukan NIK : ");
            int nik = in.nextInt();
            if(controlerPasien.getByNik(nik) == null){
                System.out.println("Tidak ada pasien dengan nomer nik tersebut");
                return;
            }
            controlerPasien.viewAllPoli();
            System.out.print("Masukan pilihan poli : ");
            int poli = in.nextInt();
            controlerPasien.addPasienToPoliByNik(poli, nik);
            int noAntrian = controlerPasien.getNoAntrian(poli);
            System.out.println("Antrian anda : "+noAntrian);
        } else if (pilihan == 2) {
            System.out.print("Masukan nomer BPJS : ");
            int bpjs = in.nextInt();
            if(controlerPasien.getByBpjs(bpjs) == null){
                System.out.println("Tidak ada pasien dengan nomer BPJS tersebut");
                return;
            }
            controlerPasien.viewAllPoli();
            System.out.print("Masukan pilihan poli : ");
            int poli = in.nextInt();
            controlerPasien.addPasienToPoliByBpjs(poli, bpjs);
            int noAntrian = controlerPasien.getNoAntrian(poli);
            System.out.println("Antrian anda : "+noAntrian);
        } else {
            System.out.println("error salah");
        }
    }

    public static void Login() {
        System.out.println("Masukkan username : ");
        in.nextLine();
        String username = in.nextLine();
        System.out.println("Masukkan password : ");
        String password = in.nextLine();
        if (controlerLogin.validasi(username, password)) {
            System.out.println("Login Berhasil");
            viewAdmin.mianView();
        } else {
            System.out.println("Login gagal");
        }
    }
}
