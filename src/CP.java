/**
 * Class publica (CP)
 * Constituida por duas subclasses (CenarioA e Cenario B)
 * Retorna o valor do CP consuante o cenario e a velocidade
 * Se o valor da velocidade não for igual a nenhum dos valores do array val_tabelados, o codigo irá fazer interpolação dos valores para retornar o valor pretendido
 *
 * @author Diogo de Matos e Miguel Gordicho
 */

public abstract class CP {
    public abstract double interpolacao();
    public static final double[] val_tabeladosVel = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
}

abstract class CenarioA extends CP{
    public static double interpolacao(double vel){
        double[] val_tabeladosCPa = {0,0,0.02, 0.30, 0.40, 0.44, 0.41, 0.35, 0.26, 0.18};
        for (int i = 0; i < val_tabeladosVel.length; i++) {
            if(vel==val_tabeladosVel[i]){
                return val_tabeladosCPa[i];
            }
            if (val_tabeladosVel[i] < vel && vel < val_tabeladosVel[i+1]) {
                return val_tabeladosCPa[i]+((val_tabeladosCPa[i+1]-val_tabeladosCPa[i])/(val_tabeladosVel[i+1]-val_tabeladosVel[i]))*(vel-val_tabeladosVel[i]);
            }
        }
        return 0;
    }
}
abstract class CenarioB extends CP{
    public static double interpolacao(double vel){
        double[] val_tabeladosCPb = {0,0,0.04, 0.18, 0.26, 0.36, 0.48, 0.52, 0.40, 0.28};
        for (int i= 0; i < val_tabeladosVel.length; i++) {
            if(vel==val_tabeladosVel[i]){
                return val_tabeladosCPb[i];
            }
            if (val_tabeladosVel[i] < vel && vel < val_tabeladosVel[i+1]) {
                return val_tabeladosCPb[i]+((val_tabeladosCPb[i+1]-val_tabeladosCPb[i])/(val_tabeladosVel[i+1]-val_tabeladosVel[i]))*(vel-val_tabeladosVel[i]);
            }
        }
        return 0;
    }
}
