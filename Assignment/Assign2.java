package Comp.Assignment;

class Staff{
    public void bark(){
        System.out.println("Guk guk guk");
    }
}
class Thread1 extends Thread{
    public void run(){
        for(int i=1 ; i<11;i++){
            try{Thread.sleep(50);}catch(InterruptedException e){System.out.println(e);}
            System.out.println("G2Academy");
        }
    }

}
class Thread2 extends Thread{
    public void run(){
        for(int i=1 ; i<11;i++){
            try{Thread.sleep(50);}catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
        }
    }
}

public class Assign2 {
    public static void main(String []args){
        Thread1 ass1 = new Thread1();
        Thread2 ass2 = new Thread2();
        ass1.start();
        ass2.start();
    }
}
