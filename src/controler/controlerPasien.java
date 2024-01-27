package controler;

import model.*;
import node.*;

import static model.modelPoli.listPoli;

public class controlerPasien {
    modelPasien modelPasien = new modelPasien();
    modelTransaksi modelTransaksi = new modelTransaksi();

    modelPoli modelPoli = new modelPoli();

    public void addPasien(String nama, String alamat, String kelamin, String ttl, int nik, int bpjs){
        modelPasien.add(new nodePasien(nama, alamat, kelamin, ttl, nik, bpjs));
        modelPoli.commitData();
    }

    public nodePasien getByNik(int nik){
        return modelPasien.searchByNik(nik);
    }

    public nodePasien getByBpjs(int bpjs){
        return modelPasien.searchByBpjs(bpjs);
    }

    public nodePoli getPoli(int idPoli){
        return modelPoli.get(idPoli);
    }

    public void addPasienToPoliByNik(int idPoli, int nik){
        modelPoli.get(idPoli).setPasien(modelPasien.searchByNik(nik));
        modelPoli.commitData();
    }

    public void addPasienToPoliByBpjs(int idPoli, int bpjs){
        modelPoli.get(idPoli).setPasien(modelPasien.searchByBpjs(bpjs));
        modelPoli.commitData();
    }

    public int getNoAntrian(int idPoli){
        int noAntrian = modelTransaksi.generateRandomAntrian();
        nodeTransaksi transaksi = new nodeTransaksi(modelTransaksi.getLastKode(),noAntrian,getPoli(idPoli));
        modelTransaksi.add(transaksi);
        modelTransaksi.commitData();
        return noAntrian;
    }

    public void viewAllPoli(){
        if (listPoli.isEmpty()) {
            System.out.println("Tidak tersedia.");
        } else {
            System.out.println("list poli:");
            for (nodePoli poli : listPoli) {
                System.out.println(+poli.getIdPoli()+" "+poli.getNamaPoli());
            }
        }
    }
}
