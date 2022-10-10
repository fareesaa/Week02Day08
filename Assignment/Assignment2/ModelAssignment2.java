package Comp.Assignment.Assignment2;

import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;

public class ModelAssignment2 {
    Map m = new HashMap();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);
    public void loadDataFile(){
        try{
            System.out.println("Masukkan Username anda: ");
            String uname  = inputStr.next();
            System.out.println("Masukkan Password anda: ");
            String pass  = inputStr.next();
            FileReader fr1 = new FileReader("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Week02Day08\\file\\Username.txt");

            FileReader fr2 = new FileReader("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Week02Day08\\file\\Password.txt");

            int x=0;
            String username = "";
            while(( x=fr1.read())!=-1){
                username = username + (char)x;
            }


            int y=0;
            String password= "";
            while (( y = fr2.read())!=-1){
                password = password+(char)y;
            }
            System.out.println(uname);
            System.out.println(password);

            String [] parsedNl = username.split("\n");
            System.out.println(parsedNl.length);
            String [] parsedPass = password.split("\n");
            System.out.println(parsedPass.length);

            String regUname = "^[A-Za-z0-9+_.-]+@(.+)$";
            boolean regexUsername = Pattern.matches(regUname, uname);
            String regPass = ".{8,32}" + "[a-zA-z]*" + "\\w*";
            boolean regexPassword = Pattern.matches(regPass, pass);
            boolean login ;
            if(regexUsername==true && regexPassword==true){
                login = true;

            }else{
                login = false;
            }

            if(login==true && uname.equals(username) && pass.equals(password)){
                System.out.println("===Selamat login telah berhasil===");
            }
            else {
                System.out.println("Login gagal!");
            }


            //Longkap 1 untuk melewati head
           /* for(int i = 1; i<parsedNl.length; i++){

                String [] parseComma = parsedNl[i].split(",");

                int getId = Integer.parseInt(parseComma[0]);
                String getNama = parseComma[1];
                int getTotGaji = Integer.parseInt(parseComma[2]);

                *//*Staff st = new Staff(getId,getNama,getTotGaji);
                arrStaffView.add(st);*//*
            }


            System.out.println(s);*/
            fr1.close();
            fr2.close();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("load success...");

    }
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
    public void editMhs(){
        System.out.println("Input ID : ");
        int id =inputInt.nextInt();
        Set set  = m.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()){
            Map.Entry entry = (Map.Entry) itr.next();
            Mahasiswa mhs = (Mahasiswa) entry.getValue();
            ArrayList alN = mhs.getAlNilai();
            if(mhs.getId()==id){
                System.out.println("Masukkan nama terbaru!");
                String nama = inputStr.nextLine();

                m.replace(mhs.getId(),new Mahasiswa(id,nama ,alN));
                System.out.println("Data nama pada id "+id+"telah berhasil diubah!");
            }


        }
    }
    public void deleteMhs(){
        System.out.println("Input ID : ");
        int id =inputInt.nextInt();
        Set set  = m.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()){
            Map.Entry entry = (Map.Entry) itr.next();
            Mahasiswa mhs = (Mahasiswa) entry.getValue();
            ArrayList alN = mhs.getAlNilai();
            if(mhs.getId()==id){
                System.out.println("Masukkan nama terbaru!");
                String nama = inputStr.nextLine();

                m.remove(mhs.getId());
                System.out.println("Data nama pada id "+id+"telah berhasil diubah!");
            }


        }
    }
    public void tampilMhs(){
        Set set = m.entrySet();
        Iterator itr = set.iterator();
        System.out.println("ID\tNama\tB.Inggris\tFisika\tAlgoritma");
        while (itr.hasNext()){
            Map.Entry entry= (Map.Entry)itr.next();
            Mahasiswa mhs =(Mahasiswa) entry.getValue();

            ArrayList nilai = mhs.getAlNilai();
            System.out.println(entry.getKey()+"\t"+ mhs.getNama()+"\t"+nilai.get(0)+"\t"+nilai.get(1)+"\t"+nilai.get(2));
        }
    }
}
