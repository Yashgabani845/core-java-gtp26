package exception_handling.task;


class CustomInvalidNumberException extends Exception{
    public CustomInvalidNumberException(String msg){
        super(msg);
    }
}
public class consoleApp {
    public static void main(String[] args){
        double sum = 0;
        for(int i=0;i<args.length;i++){
            try {
                double d = Double.parseDouble(args[i]);
                sum+=d;
            }catch (NumberFormatException e){
                try{
                    throw new CustomInvalidNumberException("Can't convert "+args[i] + " into number");
                }catch (CustomInvalidNumberException e1){
                    System.out.println(e1.getMessage());
                }
            }
        }
        System.out.println(sum);
    }
}
