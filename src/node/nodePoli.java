package node;

public class nodePoli {
    public int idPoli;
    public String namaPoli;
    public nodePasien pasien;

    public nodePoli(int idPoli, String namaPoli,nodePasien pasien) {
        this.idPoli = idPoli;
        this.namaPoli = namaPoli;
        this.pasien = pasien;
    }

    public int getIdPoli(){
        return this.idPoli;
    }

    public void setIdPoli(int idPoli){
        this.idPoli = idPoli;
    }
    public String getNamaPoli(){
        return this.namaPoli;
    }

    public void setNamaPoli(String namaPoli){
        this.namaPoli = namaPoli;
    }

    public nodePasien getPasien(){
        return this.pasien;
    }

    public void setPasien(nodePasien pasien){
        this.pasien = pasien;
    }
}
