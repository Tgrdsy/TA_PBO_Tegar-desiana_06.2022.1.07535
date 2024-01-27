package node;

import java.util.ArrayList;

public class nodePasien {
    public String nama;
    public String alamat;
    public String kelamin;
    public String ttl;
    public int nik;
    public int bpjs;

    public nodePasien(String nama, String alamat, String kelamin, String ttl, int nik, int bpjs) {
        this.nama = nama;
        this.alamat = alamat;
        this.kelamin = kelamin;
        this.ttl = ttl;
        this.nik = nik;
        this.bpjs = bpjs;
    }

    public String getNama(){
        return this.nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getAlamat(){
        return this.alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getKelamin(){
        return this.kelamin;
    }

    public void setKelamin(String kelamin){
        this.kelamin = kelamin;
    }

    public String getTTL(){
        return this.ttl;
    }

    public void setTTL(String ttl){
        this.ttl = ttl;
    }

    public int getNIK(){
        return this.nik;
    }

    public void setNIK(int nik){
        this.nik = nik;
    }

    public int getBPJS(){
        return this.bpjs;
    }

    public void setBPJS(int bpjs){
        this.bpjs = bpjs;
    }
}
