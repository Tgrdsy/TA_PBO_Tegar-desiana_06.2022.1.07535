package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.*;

import java.util.ArrayList;

public class modelAdmin implements CRUD<nodeAdmin> {
    public ArrayList<nodeAdmin> listAdmin;
    modelJSON<nodeAdmin> modelJSONAdmin;
    public modelAdmin() {
        listAdmin = new ArrayList<>();
        modelJSONAdmin = new modelJSON<nodeAdmin>("src/Database/Admin.json");
        loadData();
    }

    private void loadData() {
        listAdmin = modelJSONAdmin.readFromFile(new TypeToken<ArrayList<nodeAdmin>>() {
        }.getType());

    }

    public void commitData() {
        modelJSONAdmin.writeToFile(listAdmin);
    }
    @Override
    public void add(nodeAdmin admin) {
        listAdmin.add(admin);
    }

    public nodeAdmin get(int id){
        return null;
    }

    public boolean edit(nodeAdmin admin){
        return false;
    }

    public boolean delete(int id){
        return false;
    }

    public nodeAdmin searchByNik(int nik){
        return null;
    }

    public nodeAdmin searchByBpjs(int bpjs){
        return null;
    }
}
