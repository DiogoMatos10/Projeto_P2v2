/**
 * Class publica (Atmosfera).
 * Class constituida pelo método getCalcDensidade, este utilizado para calcular a densidade do ar segundo uma altitude recebida pelo utilizador.
 *
 * @author Diogo de Matos e Miguel Gordicho.
 */

public class Atmosfera {

    /**
     * Variável de instância constantes (final) que servem para calcular a pressão (double p) e o valor returnado pelo método getCalcDensidade(double altitude).
     */

    private static final double tinicial=288.15,l=0.0065,pinicial=101325,g=9.80665,r=9.31447,m=0.0289644;

    /**
     * Método que retorna o valor da densidade do ar, utilizado no método getPt() da class Aerogerador.
     * @param altitude (Altitude de um aerogerador).
     * @return valor da densidade do ar segundo a altitude de um aerogerador.
     */

    public static double getCalcDensidade(double altitude){
        double p=pinicial*Math.pow((1-((l*altitude)/tinicial)),((g*m)/(r*l)));
        return ((p*m)/(r*(tinicial-l*altitude)));
    }
}
