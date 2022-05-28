import java.util.ArrayList;

public class Parque_Eolico{
    public static ArrayList<Aerogerador> Lista= new ArrayList<>();

    public Parque_Eolico() {
    }

    public void addAerogerador(Aerogerador aerogerador){
        Lista.add(aerogerador);
    }
    public double[] getOne(int i){
        Aerogerador aerogerador=Lista.get(i-1);
        return aerogerador.toArray();
    }
    public void removeOne(int i){
        Lista.remove(i-1);
    }
    public int getQuantAero(){
        int count=0;
        for (Aerogerador aerogerador : Lista) {
            if (aerogerador instanceof Aerogerador) {
                count++;
            }
        }
        return count;
    }
    public int getQuantAeroAcima(double alt){
        int count=0;
        for (Aerogerador aerogerador : Lista) {
            double[] array = aerogerador.toArray();
            if (array[3] >= alt) {
                count++;
            }
        }
        return count;
    }
    //Verificar
    public void manutencaoGerador(int n, int tipo_gerador){
        double[] array=getOne(n);
        if(tipo_gerador==1 || tipo_gerador==2){
            array[0]=tipo_gerador;
            Aerogerador newAerogerador=new Aerogerador((int) array[0],array[1],array[2],array[3], array[4],array[5]);
            Lista.set(n-1, newAerogerador);
            System.out.println("Manuntenção do gerador realizada com sucesso.");
        }else{
            System.out.println("Erro: O tipo de gerador só pode ser de tipo 1 ou 2.");
        }
    }
    public void manutencaoRotor(int n, double raio){
        double[] array=getOne(n);
        if(array[3]-raio>=4){
            array[1]=raio;
            Aerogerador newAerogerador=new Aerogerador((int) array[0],array[1],array[2],array[3], array[4],array[5]);
            Lista.set(n-1, newAerogerador);
            System.out.println("Manuntenção do rotor realizada com sucesso.");
        }else{
            System.out.println("Não se alterou o valor do raio do Rotor. A diferença entre a altura do eixo até ao solo e o raio de envergadura das pás tem de ser maior ou igual a 4 metros.");
        }
    }
    public void manutencaoAmbos(int n,double raio, int tipo_gerador){
        manutencaoGerador(n,tipo_gerador);
        manutencaoRotor(n,raio);
    }

    public double getCalcPTNumInstante(int i, double vel){
        Aerogerador aerogerador=Lista.get(i-1);
        aerogerador.setVelocidade(vel);
        return aerogerador.getPt();
    }
    public double[] getCalcPTVariosInstantes(int n,double[] vel){
        double[] PTs=new double[vel.length];
        Aerogerador aerogerador=Lista.get(n-1);
        for(int i=0;i<vel.length;i++){
            aerogerador.setVelocidade(vel[i]);
            PTs[i]=aerogerador.getPt();
        }
        return PTs;
    }
    public double getAllCalcPT(double vel){
        double res=0;
        for (Aerogerador aerogerador : Lista) {
            aerogerador.setVelocidade(vel);
            res += aerogerador.getPt();
        }
        return res;
    }
}
