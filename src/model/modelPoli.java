package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.nodePoli;

import java.util.ArrayList;

public class modelPoli implements CRUD<nodePoli> {
    public static ArrayList<nodePoli> listPoli;
    modelJSON<nodePoli> modelJSONPoli;

    public modelPoli() {
        listPoli = new ArrayList<>();
        modelJSONPoli = new modelJSON<nodePoli>("src/Database/Poli.json");
        loadData();
    }
    private void loadData() {
        listPoli = modelJSONPoli. readFromFile(new TypeToken<ArrayList<nodePoli>>() {}.getType());
    }

    public void commitData() {
        modelJSONPoli.writeToFile(listPoli);
    }
    public int getLastKode(){
        int last = listPoli.size()-1;
        if (last < 0){
            return 0;
        }else {
            return listPoli.get(last).getIdPoli();
        }
    }

    private void updatePoliIds() {
        // Mengupdate ID poli agar urut kembali
        for (int i = 0; i < listPoli.size(); i++) {
            listPoli.get(i).idPoli = i + 1;
        }
    }

    public void add(nodePoli poli) {
        listPoli.add(poli);
    }

    public nodePoli get(int id){
        for (nodePoli poli : listPoli){
            if (poli.idPoli == id) {
                return poli;
            }
        }
        return null;
    }

    public boolean edit(nodePoli poli){
        nodePoli poli2 = get(poli.idPoli);
        if (poli2 != null ){
            poli2.setNamaPoli(poli.getNamaPoli());
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        nodePoli poli = get(id);
        if (poli != null){
            listPoli.remove(poli);
            return true;
        }
        return false;
    }

    public nodePoli searchByNik(int id){
        return null;
    }

    public nodePoli searchByBpjs(int id){
        return null;
    }
}
