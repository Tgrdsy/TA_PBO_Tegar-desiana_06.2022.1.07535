package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.nodePasien;

import java.util.ArrayList;

public class modelPasien implements CRUD<nodePasien> {
    public ArrayList<nodePasien> listPasien;
    modelJSON<nodePasien> modelJSONPasien;
    public modelPasien() {
        listPasien = new ArrayList<>();
        modelJSONPasien = new modelJSON<nodePasien>("src/Database/Pasien.json");
        loadData();
    }

    private void loadData() {
        listPasien = modelJSONPasien.readFromFile(new TypeToken<ArrayList<nodePasien>>() {
        }.getType());

    }

    public void commitData() {
        modelJSONPasien.writeToFile(listPasien);
    }

    @Override
    public void add(nodePasien pasien) {
        listPasien.add(pasien);
    }
    @Override
    public boolean delete(int nik){
        nodePasien pasien = searchByNik(nik);
        if (pasien != null){
            listPasien.remove(pasien);
            return true;
        }
        return false;
    }
    @Override
    public nodePasien searchByNik(int nik){
        for (nodePasien pasien : listPasien){
            if (pasien.getNIK() == nik) {
                return pasien;
            }
        }
        return null;
    }

    @Override
    public nodePasien searchByBpjs(int bpjs){
        for (nodePasien pasien : listPasien){
            if (pasien.getBPJS() == bpjs) {
                return pasien;
            }
        }
        return null;
    }
    @Override
    public boolean edit(nodePasien Pasien){
        nodePasien pasien = searchByNik(Pasien.getNIK());
        if (pasien != null ){
            pasien.setNama(Pasien.getNama());
            pasien.setAlamat(Pasien.getAlamat());
            pasien.setKelamin(Pasien.getKelamin());
            pasien.setTTL(Pasien.getTTL());
            pasien.setNIK(Pasien.getNIK());
            pasien.setBPJS(Pasien.getBPJS());
            return true;
        }
        return false;
    }

    public nodePasien get(int id){
        return null;
    }
}
