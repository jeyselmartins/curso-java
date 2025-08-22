import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        double notaUm = Leitor.lerDouble("Informe a nota um: ", "Nota um inválida!!", 0 , 10);

        double notaDois = Leitor.lerDouble("Informe a nota dois: ", "Nota dois inválida!!", 0 , 10);

        double media = MyMath.media(notaUm, notaDois);

       if(media > 7){
           System.out.println("Aprovado");
       }else{
           System.out.println("Reprovado");
       }

        System.out.println("O valor da média eh: " + media);
    }


}