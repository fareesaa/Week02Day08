package Comp.Assignment.Assignment2;

import java.util.ArrayList;

public class Mahasiswa {
    int id;
    String nama="";
    ArrayList alNilai   = new ArrayList();
    String uname ="";
    String password="";
    public Mahasiswa(int id, String nama,ArrayList alNilai){
        this.id= id;
        this.nama = nama;
        this.alNilai =alNilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList getAlNilai() {
        return alNilai;
    }

    public void setAlNilai(ArrayList alNilai) {
        this.alNilai = alNilai;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
