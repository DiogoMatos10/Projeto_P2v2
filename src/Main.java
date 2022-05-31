import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Parque_Eolico parque_eolico=new Parque_Eolico();


        //Declaração dos aerogeradores com as caracteristicasa
        Aerogerador aerogerador=new Aerogerador(1,2,4,8,5,10);
        Aerogerador aerogerador2=new Aerogerador(2,10,50,15,100,120);
        Aerogerador aerogerador3=new Aerogerador(1,4,10,10,66,360);
        //Demonstração quando um aerogerador tem caracteristicas que não cumprem os requesitos:
        Aerogerador aerogerador4=new Aerogerador(5,2,3,15,200,220);


        //Adicionar aerogeradores ao Parque Eólico
        parque_eolico.addAerogerador(aerogerador);
        parque_eolico.addAerogerador(aerogerador2);
        parque_eolico.addAerogerador(aerogerador3);
        //Demonstração quando um aerogerador tem caracteristicas que não cumprem os requesitos e queremos adicionar:
        parque_eolico.addAerogerador(aerogerador4);


        //Remover um aerogerador do Parque Eólico
        parque_eolico.removeAerogerador(1);
        //Demonstração em como foi removido
        System.out.println(Arrays.toString(parque_eolico.getAerogerador(1)));


        //Quantidade de aerogeradores existentes cuja turbina está instalada acima de determinada altura ao solo
        System.out.println(parque_eolico.getQuantAero());


        //Quantidade de aerogeradores existentes com
        System.out.println(parque_eolico.getQuantAlturaAcima(3));


        //Manuntenção do rotor e do gerador
        parque_eolico.manutencaoAmbos(1,3,2);
        //Demonstração do aerogerador com as novas caracteristicas
        System.out.println(Arrays.toString(parque_eolico.getAerogerador(1)));


        //Manuntenção do rotor
        parque_eolico.manutencaoRotor(2,2);
        //Demonstração do aerogerador com as novas caracteristicas
        System.out.println(Arrays.toString(parque_eolico.getAerogerador(2)));


        //Manuntenção do gerador
        parque_eolico.manutencaoGerador(2,2);
        System.out.println(Arrays.toString(parque_eolico.getAerogerador(2)));


        //Cálculo da energia/potência gerado por um aerogerador num instante, ou seja, segundo uma velocidade
        System.out.println(parque_eolico.getCalcPTNumInstante(1,22));


        //Cálculo da energia/potência total gerada por todos os aerogeradores existentes
        System.out.println(parque_eolico.getAllCalcPT(7.5));


        //Cálculo da energia/potência gerada por um aerogerador para várias instantes/dias, ou seja, várias velocidades
        double[] velArray={3.5 , 2 , 8.2 , 9,3 , 2};
        System.out.println(Arrays.toString(parque_eolico.getCalcPTVariosInstantes(1, velArray)));
    }
}

