/**
 * Class publica (Atmosfera)
 * Class utilizada para calcular a densidade do ar segundo uma altitude recebida pela utilizador
 * Tem declaradas variaveis constantes para o calculo
 *
 * @author Diogo de Matos e Miguel Gordicho
 */

public class Atmosfera {
    private static final double tinicial=288.15,l=0.0065,pinicial=101325,g=9.80665,r=9.31447,m=0.0289644;
    public static double Calc_densidade(double altitude){
        double p=pinicial*Math.pow((1-((l*altitude)/tinicial)),((g*m)/(r*l)));
        return ((p*m)/(r*(tinicial-l*altitude)));
    }
}
