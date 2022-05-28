/**
 * Class publica (Aerogerador).
 * Class constituida por um constructor e pelos métodos:
 * - setVelocidade
 * - getPt
 * - toArray
 * @author Diogo de Matos e Miguel Gordicho
 */

public class Aerogerador {

    /**
     * Variáveis de instancia que armazenam os valores das caracteristicas de um aerogerador.
     * int tipo_gerador - tipo de gerador G1 ou G2 mas como a variável é do tipo integer então só pode armazenar valores inteiros 1 ou 2.
     * double raio - raio da zona de captação do vento, ou seja, o comprimento de cada pá do aerogerador.
     * double altitude - altitude onde foi instalado um aerogerador.
     * double alturaEixo - altura do eixo de rotação ao solo.
     * double longitude - longitude onde foi instalado um aerogerador.
     * double latitude - latitude onde foi instalado um aerogerador.
     * double vel - velocidade do vento num certo instante e localização.
     */

    private int tipo_gerador;
    private double vel,raio,altitude, alturaEixo, longitude,latitude;

    /**
     * Constructor da class Aerogerador que quarda nas variáveis de instância declaradas em cima os valores dos argumentos.
     * @param tipo_gerador - tipo de gerador
     * @param raio - raio da zona de captação do vento
     * @param altitude - altitude onde foi instalado um aerogerador
     * @param alturaEixo - altura do eixo de rotação ao solo
     * @param longitude - longitude onde foi instalado um aerogerador
     * @param latitude - velocidade do vento num certo instante e localização
     */

    public Aerogerador(int tipo_gerador,double raio,double altitude,double alturaEixo, double longitude, double latitude) {
        try{
            if(alturaEixo-raio<4){
                throw new Exception("A diferença entre a altura do eixo até ao solo e o raio de envergadura das pás tem de ser maior ou igual a 4 metros");

            }else{
                this.tipo_gerador = tipo_gerador;
                this.alturaEixo = alturaEixo;
                this.raio = raio;
                this.altitude = altitude;
                this.longitude = longitude;
                this.latitude = latitude;
            }
        }catch (Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    /**
     * Método que recebe o valor da velocidade do vento num certo instante e o armazena.
     * Utilizado nos métodos getCalcPTNumInstante, getCalcPTVariosInstantes, getAllCalcPT da class Parque_Eolico.
     * @param vel (Velocidade do vento inserida pelo utilizador).
     */

    public void setVelocidade(double vel){
        this.vel=vel;
    }

    /**
     * Método que retorna o valor da potência de energia gerada segundo um valor da velocidade do vento num certo instante e numa certa localização.
     * Utiliza o método getCalcDensidade da class Atmosfera e utiliza os métodos getGPA e getGPB das subclasses da class abstrata CP.
     * Utilizado nos métodos e class referenciados acima.
     * @return valor da Potência de Energia por um aerogerador.
     */

    public double getPt(){
        double densidade=Atmosfera.getCalcDensidade(altitude);
        double area=Math.PI*Math.pow(raio,2);
        double Pv=0.50*densidade*area*Math.pow(vel,3);
        if(tipo_gerador==1 && raio<8){
            return Pv*CenarioA.getGPA(vel);
        }
        else if(8<=raio || tipo_gerador==2) {
            return Pv * CenarioB.getCPB(vel);
        }
        return 0;
    }

    /**
     * Método responsável pelo retorno das caracteristicas de um aerogerador na forma de um array de doubles.
     * Utilizado nos métodos getOne e getQuantAeroAcima da class Parque_Eolico.
     * @return Array de tamanho 6 com as caaracteristicas de um aerogerador, estando distribuido da seguinte forma:
     * 1ª posição - Tipo de gerador
     * 2ª posição - raio da zona de captação do vento
     * 3ª posição - altitude onde foi instalado um aerogerador
     * 4ª posição - altura do eixo de rotação ao solo
     * 5ª posição - longitude onde foi instalado um aerogerador
     * 6ª posição - latitude onde foi instalado um aerogerador
     */

    public double[] toArray(){
        double [] info=new double[6];
        info[0]=tipo_gerador;
        info[1]=raio;
        info[2]=altitude;
        info[3]= alturaEixo;
        info[4]=longitude;
        info[5]=latitude;
        return info;
    }
}
