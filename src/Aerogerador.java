import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

/**
 * Class publica (Aerogerador)
 * Constituida por um constructor que recebe as caracteristicas de um aerogerador (tipo de gerador, raio
 *
 *
 *
 *
 * @author Diogo de Matos e Miguel Gordicho
 */



public class Aerogerador {
    private int tipo_gerador;
    private double vel,raio,altitude, alturaEixo, longitude,latitude;
    public Aerogerador(int tipo_gerador,double raio,double altitude,double alturaEixo, double longitude, double latitude) {
        this.tipo_gerador = tipo_gerador;
        this.alturaEixo=alturaEixo;
        this.raio = raio;
        this.altitude = altitude;
        this.longitude=longitude;
        this.latitude=latitude;
    }
    public void setVelocidade(double vel){
        this.vel = vel;
    }
    public double get_Pt(){
        double densidade=Atmosfera.Calc_densidade(altitude);
        double area=Math.PI*Math.pow(raio,2);
        double Pv=0.50*densidade*area*Math.pow(vel,3);
        if(tipo_gerador==1 && raio<8){
            return Pv*CenarioA.interpolacao(vel);
        }
        else if(8<=raio || tipo_gerador==2) {
            return Pv * CenarioB.interpolacao(vel);
        }
        return 0;
    }
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
