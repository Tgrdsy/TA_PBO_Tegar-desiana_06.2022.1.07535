package node;

public class nodeTransaksi {
    public int idTransaksi;
    public int noAntrian;
    public nodePoli poli;

    public nodeTransaksi(int idTransaksi, int noAntrian, nodePoli poli) {
        this.idTransaksi = idTransaksi;
        this.noAntrian = noAntrian;
        this.poli = poli;
    }

    public int getNoAntrian(){
        return this.noAntrian;
    }

    public void setNoAntrian(int noAntrian){
        this.noAntrian = noAntrian;
    }

    public nodePoli getPoli(){
        return this.poli;
    }

    public void setPoli(nodePoli poli){
        this.poli = poli;
    }

    public int getIdTransaksi(){
        return this.idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi){
        this.idTransaksi = idTransaksi;
    }
}
