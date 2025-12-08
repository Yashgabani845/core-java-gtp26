import java.io.*;

interface Vehicle {
    void changeGear(int a);
    void speedup(int b);
}
class Bicycle  implements  Vehicle {
    int speed;
    int gear;

    public Bicycle(int speed , int gear){
        this.speed = speed;
        this.gear = gear;
    }
    public  void changeGear (int gear){
        this.gear = gear;
    }
    public void speedup(int increment){
        this.speed= this.speed + increment;
    }
    public void printcurrent(){
        System.out.println(speed);
        System.out.println(gear);
    }
}


public class Interfacecode {
    public static void main(String[] args) {
    Bicycle bi = new Bicycle(50 , 1);
    bi.changeGear(2);
    bi.printcurrent();
    bi.speedup(10);
    bi.printcurrent();
    }
}

