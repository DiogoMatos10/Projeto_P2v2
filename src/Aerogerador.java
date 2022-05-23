/**
 * Class publica (Aerogerador)
 *
 */



public class Aerogerador {
    private static String gerador;
    private static double h;
    private static double r;
    private static double v;
    private double altura;
    public Aerogerador(String op_gerador, double vel, double raio, double altitude) {
        gerador = op_gerador;
        v = vel;
        r = raio;
        h = altitude;
    }
    public void
    public double get_Pt(){
        double densidade=Atmosfera.Calc_densidade(h);
        double area=Math.PI*Math.pow(r,2);
        double Pv=0.50*densidade*area*Math.pow(v,3);
        if(gerador.equals("G1") && r<8){
            return Pv*CenarioA.interpolacao(v);
        }
        else if(8<=r || gerador.equals("G2")) {
            return Pv * CenarioB.interpolacao(v);
        }
        return 0;
    }
    public String convertString(){
        return "["+gerador+","+v+","+r+","+h+","+get_Pt()+"]";
    }
}
