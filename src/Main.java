import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double h,v,a;
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
                int tipo_gerador=input.nextInt();
                double alturaEixo=input.nextDouble();
                System.out.println("Altitude: ");
                double h2=input.nextDouble();
               System.out.println("Velocidade do vento: ");
                double v2=input.nextDouble();
                System.out.println("Raio da área circular do rotor: ");
                double a2=input.nextDouble();
                System.out.println("Insira o tipo de gerador (G1 ou G2): ");
                int tipo_gerador2=input.nextInt();
                double alturaEixo2=input.nextDouble();
                Aerogerador aerogerador=new Aerogerador(tipo_gerador,a,h,alturaEixo);
                Aerogerador aerogerador1=new Aerogerador(tipo_gerador2,a2,h2,alturaEixo2);
                //System.out.println(aerogerador.get_Pt());
               // System.out.println(aerogerador1.get_Pt());
                Parque_Eolico parque_eolico=new Parque_Eolico();
                parque_eolico.addAerogerador(aerogerador);
                parque_eolico.addAerogerador(aerogerador1);
                //System.out.println(Arrays.toString(parque_eolico.getOne(1)));
                //System.out.println(parque_eolico.quantAero());
                //System.out.println(parque_eolico.quantAeroAcima(3));
                parque_eolico.manutencao(1,"Rotor",3,2);
                //System.out.println(Arrays.toString(parque_eolico.getOne(0)))
        double[] vel={4,4};
                System.out.println(Arrays.toString(parque_eolico.getCalcPTVariosInstantes(1, vel)));

        input.close();
            }
        }

