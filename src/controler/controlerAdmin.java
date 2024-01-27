package controler;

import model.*;

import static model.modelPoli.listPoli;
import static model.modelPraktek.listPraktek;
import static model.modelTransaksi.listTransaksi;
import node.*;

public class controlerAdmin {
    modelAdmin modelAdmin = new modelAdmin();
    modelPoli modelPoli = new modelPoli();
    modelPraktek modelPraktek = new modelPraktek();

    public void addPoli(String namaPoli){
        int id = modelPoli.getLastKode()+1;
        modelPoli.add(new nodePoli(id, namaPoli,null));
        modelPoli.commitData();
    }

    public void updatePraktek(int id, String namaDokter, String hari, String jam){
        modelPraktek.edit(new nodePraktek(id, namaDokter, hari, jam));
    }

    public void addPraktek(String namaDokter, String hari, String jam){
        int id = modelPoli.getLastKode()+1;
        modelPraktek.add(new nodePraktek(id, namaDokter, hari, jam));
        modelPraktek.commitData();
    }

    public void viewAllPoli(){
        if (listPoli.isEmpty()) {
            System.out.println("Tidak tersedia.");
        } else {
            System.out.println("Daftar semua poli:");
            for (nodePoli poli : listPoli) {
                System.out.println("Poli ke : "+poli.getIdPoli());
                System.out.println("Poli    : "+poli.getNamaPoli());
            }
        }
    }

    public void viewALLPraktek(){
        if (listPraktek.isEmpty()) {
            System.out.println("Jadwal Praktek Belum Tersedia");
        } else {
            System.out.println("Daftar semua Jadwal Dokter Saat Ini");
            for (nodePraktek praktek : listPraktek) {
                System.out.println("ID Praktek     : "+praktek.getIdPraktek());
                System.out.println("nama dokter    : "+praktek.getNamaDokter());
                System.out.println("hari           : "+praktek.getHari());
                System.out.println("Jam            : "+praktek.getJam());
            }
        }
    }

    public void viewALLTransaksi(){
        if (listTransaksi.isEmpty()) {
            System.out.println("Belum ada sepatu yang tersedia.");
        } else {
            System.out.println("Daftar semua transaksi :");
            for (nodeTransaksi transaksi : listTransaksi) {
                System.out.println("Trnsaksi ke : "+transaksi.getIdTransaksi());
                System.out.println("Nama        : "+transaksi.getPoli().getPasien().getNama());
                System.out.println("Alamat      : "+transaksi.getPoli().getPasien().getAlamat());
                System.out.println("Kelamin     : "+transaksi.getPoli().getPasien().getKelamin());
                System.out.println("TTL         : "+transaksi.getPoli().getPasien().getTTL());
                System.out.println("NIK         : "+transaksi.getPoli().getPasien().getNIK());
                System.out.println("BPJS        : "+transaksi.getPoli().getPasien().getBPJS());
                System.out.println("Poli        : "+transaksi.getPoli().getNamaPoli());
                System.out.println("Antrian     : "+transaksi.getNoAntrian());
            }
        }
    }
}
