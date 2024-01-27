package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.*;

import java.util.ArrayList;
import java.util.Random;

public class modelTransaksi implements CRUD<nodeTransaksi> {
    public static ArrayList<nodeTransaksi> listTransaksi;
    modelJSON<nodeTransaksi> modelJSONTransaksi;

    public modelTransaksi() {
        listTransaksi = new ArrayList<>();
        modelJSONTransaksi = new modelJSON<nodeTransaksi>("src/Database/Transaksi.json");
        loadData();
    }
    private void loadData() {
        listTransaksi = modelJSONTransaksi. readFromFile(new TypeToken<ArrayList<nodeTransaksi>>() {}.getType());
    }

    public int getLastKode(){
        int last = listTransaksi.size() - 1;
        if (last <= 0){
            return 0;
        }else {
            return listTransaksi.get(last).getIdTransaksi();
        }
    }

    public int generateRandomAntrian() {
        Random random = new Random();
        int newAntrian;
        do {
            newAntrian = random.nextInt(1000) + 1;
        } while (isAntrianExists(newAntrian));
        return newAntrian;
    }

    private boolean isAntrianExists(int antrian) {
        for (nodeTransaksi transaksi : listTransaksi) {
            if (transaksi.getNoAntrian() == antrian) {
                return true;
            }
        }
        return false;
    }

    public void commitData() {
        modelJSONTransaksi.writeToFile(listTransaksi);
    }

    public void add(nodeTransaksi transaksi) {
        listTransaksi.add(transaksi);
    }

    public nodeTransaksi get(int id){
        for (nodeTransaksi transaksi : listTransaksi){
            if (transaksi.getIdTransaksi() == id) {
                return transaksi;
            }
        }
        return null;
    }

    public boolean edit(nodeTransaksi transaksi){
        nodeTransaksi transaksi2 = get(transaksi.getIdTransaksi());
        if (transaksi2 != null ){
            transaksi2.setNoAntrian(transaksi.noAntrian);
            transaksi2.setPoli(transaksi.poli);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        nodeTransaksi transaksi = get(id);
        if (transaksi != null){
            listTransaksi.remove(transaksi);
            return true;
        }
        return false;
    }

    public nodeTransaksi searchByNik(int nik){
        return null;
    }

    public nodeTransaksi searchByBpjs(int bpjs){
        return null;
    }
}
