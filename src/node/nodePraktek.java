package node;

public class nodePraktek {
    public int idPraktek;
    public String namaDokter;
    public String hari;
    public String jam;

    public nodePraktek( int idPraktek, String namaDokter, String hari, String jam) {
        this.namaDokter = namaDokter;
        this.idPraktek = idPraktek;
        this.hari = hari;
        this.jam = jam;
    }

    public String getNamaDokter(){
        return this.namaDokter;
    }

    public void setNamaDokter(String namaDokter){
        this.namaDokter = namaDokter;
    }

    public int getIdPraktek(){
        return this.idPraktek;
    }

    public void setIdPraktek(int idPraktek){
        this.idPraktek = idPraktek;
    }
    public String getHari(){
        return this.hari;
    }

    public void setHari(String hari){
        this.hari = hari;
    }

    public String getJam(){
        return this.jam;
    }

    public void setJam(String jam){
        this.jam = jam;
    }
}
