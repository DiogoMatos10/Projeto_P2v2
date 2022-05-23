import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op_menuprinc,op_menu1, op_menu2;
        double h,v,a;
        String tipo_gerador;
        Scanner input=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("0.00");
                System.out.println("Insira os valores");
                System.out.println("Altitude: ");
                h=input.nextDouble();
                System.out.println("Velocidade do vento: ");
                v=input.nextDouble();
                System.out.println("Raio da área circular do rotor: ");
                a=input.nextDouble();
                System.out.println("Insira o tipo de gerador (G1 ou G2): ");
                tipo_gerador=input.next();
                System.out.println("Altitude: ");
                double h2=input.nextDouble();
               System.out.println("Velocidade do vento: ");
                double v2=input.nextDouble();
                System.out.println("Raio da área circular do rotor: ");
                double a2=input.nextDouble();
                System.out.println("Insira o tipo de gerador (G1 ou G2): ");
                String tipo_gerador2=input.next();
                Aerogerador aerogerador=new Aerogerador(tipo_gerador,v,a,h);
                Aerogerador aerogerador1=new Aerogerador(tipo_gerador2,v2,a2,h2);
                System.out.println(aerogerador.get_Pt());
                System.out.println(aerogerador1.get_Pt());
                Parque_Eolico.setInfo();
                Parque_Eolico.getOne();
        input.close();
            }
        }

