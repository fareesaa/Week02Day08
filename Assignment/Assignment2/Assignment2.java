package Comp.Assignment.Assignment2;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String []args){
        ModelAssignment2 model2 = new ModelAssignment2();
        Scanner inputInt = new Scanner(System.in);
        int menu;
        do{
            model2.loadDataFile();
            System.out.println("================");
            System.out.println("1.Buat Data Mahasiswa");
            System.out.println("2.Edit & Delete Data mahasiswa");
            System.out.println("3.Laporan data mahasiswa");

            System.out.println("4.EXIT");
            menu = inputInt.nextInt();
            switch (menu){
                case 1:
                    
                    model2.addMhs();
                    break;
                case 2:
                    System.out.println("Pilih menu: ");
                    int pil=inputInt.nextInt();
                    switch (pil){
                        case 1:
                            model2.editMhs();
                            break;
                        case 2:
                            model2.deleteMhs();
                            break;
                    }
                    break;
                case 3:
                    model2.tampilMhs();
                    break;
                case 4:
                    System.out.println("===Program Selesai===");
                    menu=5;
                    break;
            }
        }while (menu<4);
    }
}
