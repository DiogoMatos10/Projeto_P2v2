/**
 * Class abstrata publica (CP).
 * Constituida por duas subclasses (CenarioA e Cenario B).
 * @author Diogo de Matos e Miguel Gordicho.
 */

public abstract class CP {

    /**
     * Variável de instância do tipo array double contendo esta os valores tabelados e constantes da velocidade.
     */

    public static final double[] val_tabeladosVel = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
}

/**
 * Subclass abstrata (CenarioA) que é constituida pelo método getGPA que é responsável pelo retorno do valor do Coeficiente de Potência de um aerogerador segundo uma velocidade do vento inserida pelo utilizador.
 */

abstract class CenarioA extends CP{

    /**
     * Método que retorna o valor do tipo double do Coefiente de Potência, utilizado no método getPt() da class Aerogerador.
     * @param vel (Velocidade do ar inserida pelo utilizador).
     * @return valor do Coefiente de Potência para o Cenário A segundo uma velociade do ar.
     */

    public static double getGPA(double vel){
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

/**
 * Subclass abstrata (CenarioB) que é constituida pelo método getGPB que é responsável pelo retorno do valor do Coeficiente de Potência de um aerogerador segundo uma velocidade do vento inserida pelo utilizador.
 */

abstract class CenarioB extends CP{

    /**
     * Método que retorna o valor do tipo double do Coefiente de Potência, utilizado no método getPt() da class Aerogerador.
     * @param vel (Velocidade do vento inserida pelo utilizador).
     * @return valor do Coefiente de Potência para o Cenário B segundo uma velociade do ar.
     */

    public static double getCPB(double vel){
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
