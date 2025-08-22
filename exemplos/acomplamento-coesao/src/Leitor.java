import java.util.Scanner;

public class Leitor {
    public static double lerDouble(String msg, String msgError,  double min, double max){
        double valor;
        do{
            valor = lerDouble(msg);
            if(valor < min || valor > max){
                System.out.println(msgError);
            }
        }while(valor < min || valor > max);

        return valor;
    }
    public static double lerDouble(String msg){
        System.out.println(msg);
        double valor =  lerDouble();
        return valor;
    }

    public static double lerDouble(){
        return new Scanner(System.in).nextDouble();
    }
}
