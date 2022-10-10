package Comp.Assignment.Assignment3;
import java.awt.image.renderable.RenderableImage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Model3 {
    Map m = new HashMap<>();

    Scanner inputInt  = new Scanner(System.in);
    Scanner inputStr  = new Scanner(System.in);

    public void addMhs(){
        System.out.print("Input ID : ");
        int id = this.inputInt.nextInt();
        System.out.print("Input Nama : ");
        String nama = this.inputStr.next();

        ArrayList alNilai = new ArrayList();
        for(int i = 0 ; i<3; i++){
            String sout = "";
            if(i==0){
                sout = "Masukkan nilai B.Inggris: ";
            }
            else if (i==1) {
                sout = "Masukkan nilai Fisika: ";
            } else if (i==2) {
                sout = "Masukkan nilai Algoritma: ";
            }
            System.out.println(sout);
            double nilai = inputInt.nextInt();
            alNilai.add(nilai);
        }
        m.put(id, new Mahasiswa(id, nama, alNilai));
    }

    public void viewMhs(){
        Set set = m.entrySet();
        Iterator itr = set.iterator();
        System.out.println("ID\tNama\tB.Inggris\tFisika\tAlgoritma");
        while (itr.hasNext()){
            Map.Entry entry= (Map.Entry)itr.next();
            Mahasiswa mhs =(Mahasiswa) entry.getValue();

            ArrayList nilai = mhs.getNilai();
            System.out.println(entry.getKey()+"\t"+ mhs.getNama()+"\t"+nilai.get(0)+"\t"+nilai.get(1)+"\t"+nilai.get(2));
        }
    }
    public void loadMhs(){
        Set set = m.entrySet();
        Iterator itr = set.iterator();

        while (itr.hasNext()){
            Map.Entry entry =(Map.Entry) itr.next();
            Mahasiswa mhs =(Mahasiswa) entry.getValue();
            System.out.println(entry.getKey()+"\t"+ mhs.getNama());

        }
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    public void loadMap(){
        Set set = m.entrySet();
        Iterator itr = set.iterator();
        boolean cek = (itr.hasNext());
        while (itr.hasNext()){
            Map.Entry entry =(Map.Entry) itr.next();
            Mahasiswa mhs =(Mahasiswa) entry.getValue();
            System.out.println(entry.getKey()+"\t"+ mhs.getNama());

        }
    }

    public void writeMahasiswaToFile (){
        try{

            System.out.println("Masukkan dir: ");
            String dir  = inputStr.next();
            System.out.println("Masukkan file: ");
            String file  = inputStr.next();

            FileWriter fw = new FileWriter(dir+"\\"+file+".txt");
            Set set = m.entrySet();
            Iterator itr = set.iterator();
            fw.write("ID,NAMA,TOTALGAJI\n");
            while (itr.hasNext()) {
                Map.Entry entry = (Map.Entry) itr.next();
                Mahasiswa mhs = (Mahasiswa) entry.getValue();
                fw.write(entry.getKey() + "," + mhs.getNama() + "," + mhs.getNilai());
            }
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success add file...");

    }
}
class writeThread extends Thread{
    Scanner input = new Scanner(System.in);
    Model3 model3 = new Model3();

    @Override
    public void run() {
        try {
            System.out.println("Masukkan dir: ");
            String dir  = input.next();
            System.out.println("Masukkan file: ");
            String file  = input.next();

            Set set= model3.m.entrySet();
            Iterator itr = set.iterator();

            FileWriter fw = new FileWriter(dir+"\\"+file+".txt");
            while (itr.hasNext()){
                Map.Entry entry = (Map.Entry)itr.next();
                Mahasiswa mhs= (Mahasiswa) entry.getValue();
                ArrayList nilai = mhs.getNilai();
                fw.write("#ID: "+entry.getKey()
                        + "\nNama: " + mhs.getNama()
                        + "\nB.Inggris: " + nilai.get(0)
                        +"\nFisika: "+nilai.get(1)
                        +"\nAlgoritma: "+nilai.get(2));
            }
            fw.close();
            System.out.println("Successs thread write...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class viewThread extends Thread{
    Map m = new HashMap<>();
    Model3 model = new Model3();
    @Override
    public void run() {
        /*try{Thread.sleep(5000);}catch(InterruptedException e){System.out.println(e);}*/
        Set set = model.m.entrySet();
        Iterator itr = set.iterator();
        System.out.println("ID\tNama\tB.Inggris\tFisika\tAlgoritma");
        while (itr.hasNext()){
            Map.Entry entry= (Map.Entry)itr.next();
            Mahasiswa mhs =(Mahasiswa) entry.getValue();

            ArrayList nilai = mhs.getNilai();
            System.out.println(entry.getKey()+"\t"+ mhs.getNama()+"\t"+nilai.get(0)+"\t\t"+nilai.get(1)+"\t\t"+nilai.get(2));
        }
    }
}