package Comp.Assignment.Assignment3;

import java.util.ArrayList;

public class Mahasiswa {
    String nama = "";
    int id ;
    ArrayList nilai = new ArrayList();
    public Mahasiswa(int id, String nama, ArrayList nilai){
        this.id = id;
        this.nama = nama;
        this.nilai = nilai;
    }

    public ArrayList getNilai() {
        return nilai;
    }

    public void setNilai(ArrayList nilai) {
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

}
