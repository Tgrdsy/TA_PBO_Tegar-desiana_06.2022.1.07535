package controler;

import model.modelAdmin;
import node.nodeAdmin;

import java.util.ArrayList;

public class controlerLogin {
    modelAdmin modelAdmin = new modelAdmin();

    public boolean validasi(String username, String password){
        ArrayList<nodeAdmin> adminList = modelAdmin.listAdmin;
        for (nodeAdmin user : adminList) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login berhasil untuk user : " + username);
                return true;
            }
        }
        return false;
    }
}
