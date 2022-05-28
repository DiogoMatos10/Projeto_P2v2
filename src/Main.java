import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double altitude,vel,raio;
        Scanner input=new Scanner(System.in);
        Parque_Eolico parque_eolico=new Parque_Eolico();
                System.out.println("Insira os valores");
                System.out.println("Altitude: ");
                altitude=input.nextDouble();
                System.out.println("Velocidade do vento: ");
                vel=input.nextDouble();
                System.out.println("Raio da área circular do rotor: ");
                raio=input.nextDouble();
                System.out.println("Insira o tipo de gerador (G1 ou G2): ");
                int tipo_gerador=input.nextInt();
                System.out.println("Altura do eixo:");
                double alturaEixo=input.nextDouble();
                System.out.println("Longintude:");
                double longitude=input.nextDouble();
                System.out.println("Latitude:");
                double latitude=input.nextDouble();
                Aerogerador aerogerador=new Aerogerador(tipo_gerador,raio,altitude,alturaEixo,longitude,latitude);


                System.out.println("Altitude: ");
                double altitude2=input.nextDouble();
               System.out.println("Velocidade do vento: ");
                double vel2=input.nextDouble();
                System.out.println("Raio da área circular do rotor: ");
                double raio2=input.nextDouble();
                System.out.println("Insira o tipo de gerador (G1 ou G2): ");
                int tipo_gerador2=input.nextInt();
               System.out.println("Altura do eixo:");
                double alturaEixo2=input.nextDouble();
                System.out.println("Longintude:");
                double longitude2=input.nextDouble();
                System.out.println("Latitude:");
                double latitude2=input.nextDouble();
               Aerogerador aerogerador1=new Aerogerador(tipo_gerador2,raio2,altitude2,alturaEixo2,longitude2,latitude2);
                parque_eolico.addAerogerador(aerogerador);
                parque_eolico.addAerogerador(aerogerador1);
                //System.out.println(Arrays.toString(parque_eolico.getOne(1)));
                //System.out.println(parque_eolico.quantAero());
                //System.out.println(parque_eolico.quantAeroAcima(3));
               //parque_eolico.manutencaoAmbos(1,10,2);
                parque_eolico.manutencaoAmbos(1,10,2);
                parque_eolico.manutencaoAmbos(2,10,2);
                System.out.println(Arrays.toString(parque_eolico.getOne(1)));
                System.out.println(Arrays.toString(parque_eolico.getOne(2)));
       // double[] velArray={4,4};
               // System.out.println(Arrays.toString(parque_eolico.getCalcPTVariosInstantes(1, velArray)));

        input.close();
    }
}

