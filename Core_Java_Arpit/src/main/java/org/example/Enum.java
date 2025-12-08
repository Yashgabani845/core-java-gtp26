package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Enum {
    enum TrafficLight {
        RED, GREEN, YELLOW;
    }
    enum Color{
        RED, GREEN, BLUE;

        private Color(){

            System.out.println("Constructor called for: " + this);
        }

        public void display(){

            System.out.println("Color is: " + this);
        }
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
        TrafficLight x=TrafficLight.GREEN;
        System.out.println(x);

        Color c1 = Color.RED;
        c1.display();

        System.out.println("The values in colors are");
        for (Color c : Color.values()){
            System.out.println(c);
        }
    }
}