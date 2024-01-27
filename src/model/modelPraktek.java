package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.*;

import java.util.ArrayList;

public class modelPraktek implements CRUD<nodePraktek> {
    public static ArrayList<nodePraktek> listPraktek;
    modelJSON<nodePraktek> modelJSONPraktek;

    public modelPraktek() {
        listPraktek = new ArrayList<>();
        modelJSONPraktek = new modelJSON<nodePraktek>("src/Database/Praktek.json");
        loadData();
    }
    private void loadData() {
        listPraktek = modelJSONPraktek. readFromFile(new TypeToken<ArrayList<nodePraktek>>() {}.getType());
    }

    public void commitData() {
        modelJSONPraktek.writeToFile(listPraktek);
    }

    public int getLastKode(){
        int last = listPraktek.size() - 1;
        if (last <= 0){
            return 0;
        }else {
            return listPraktek.get(last).idPraktek;
        }
    }

    public void add(nodePraktek praktek) {
        listPraktek.add(praktek);
    }

    public nodePraktek get(int id){
        for (nodePraktek praktek : listPraktek){
            if (praktek.getIdPraktek() == id) {
                return praktek;
            }
        }
        return null;
    }

    public boolean edit(nodePraktek praktek){
        nodePraktek praktek2 = get(praktek.idPraktek);
        if (praktek2 != null ){
            praktek2.setNamaDokter(praktek.getNamaDokter());
            praktek2.setHari(praktek.getHari());
            praktek2.setJam(praktek.getJam());
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        nodePraktek praktek = get(id);
        if (praktek != null){
            listPraktek.remove(praktek);
            return true;
        }
        return false;
    }

    public nodePraktek searchByNik(int id){
        return null;
    }

    public nodePraktek searchByBpjs(int id){
        return null;
    }
}
