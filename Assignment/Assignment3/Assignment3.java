package Comp.Assignment.Assignment3;

import java.util.Scanner;
class Thread1 extends Thread{
    Model3 model = new Model3();

}
public class Assignment3 {
    public static void main(String []args){
        Model3 model = new Model3();
        Scanner input = new Scanner(System.in);
        int pil=0;

        do {
            System.out.println("MENU");
            System.out.println("0. Masukkan Dummy Data");
            System.out.println("1. Buat Data Mahasiswa");
            System.out.println("2. Laporan Nilai Data");
            System.out.println("3. Tampilkan di layar dan tulis ke file");

            System.out.println("99. EXIT");
            System.out.print("Input nomor : ");
            pil = input.nextInt();

            switch (pil) {
                case 1:
                    model.addMhs();
                    break;
                case 2:
                    model.viewMhs();
                    break;
                case 3:
                    writeThread t1 = new writeThread();
                    viewThread t2  =new viewThread();
                    t1.start();
                    t2.start();
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 0:

                    break;
            }
            System.out.println();

        } while(pil != 99);

        // closing the scanner object
        input.close();
    }
}
