import java.util.ArrayList;

public class Parque_Eolico{
    public static ArrayList<Aerogerador> Lista= new ArrayList<>();

    public Parque_Eolico() {
    }

    public void addAerogerador(Aerogerador aerogerador){
        Lista.add(aerogerador);
    }
    public double[] getOne(int i){
        Aerogerador aerogerador=Lista.get(i);
        return aerogerador.toArray();
    }
    public void removeOne(int i){
        Lista.remove(i-1);
    }
    public int quantAero(){
        int count=0;
        for (Aerogerador aerogerador : Lista) {
            if (aerogerador instanceof Aerogerador) {
                count++;
            }
        }
        return count;
    }
    public int quantAeroAcima(double alt){
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
    public void manutencao(int n,String opcao,double raio, int tipo_gerador){
        try {
            if (!opcao.equals("Rotor") && !opcao.equals("Gerador") && !opcao.equals("Ambos")) {
                throw new IllegalArgumentException("Erro: Digite uma opcao válida e da forma correta (Rotor/Gerador/Ambos)");
            }
            if (opcao.equals("Rotor") || opcao.equals("Ambos")) {
                Aerogerador aerogerador=Lista.get(n-1);
                double[] array=aerogerador.toArray();
                array[0]=tipo_gerador;
                if(array[3]-raio>=4){
                    array[1]=raio;
                }else{
                    System.out.println("O novo raio de captação do vento tem que ter uma margem de 4 metros até ao solo");
                }
                Lista.set(n-1,aerogerador);
            }
            if(opcao.equals("Gerador")){
                Aerogerador a=Lista.get(n-1);
                double[]array=a.toArray();
                array[0]=tipo_gerador;
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public double getCalcPTNumInstante(int i, double vel){
        Aerogerador aerogerador=Lista.get(i-1);
        aerogerador.setVelocidade(vel);
        return aerogerador.get_Pt();
    }
    public double[] getCalcPTVariosInstantes(int n,double[] vel){
        double[] PTs=new double[vel.length];
        Aerogerador aerogerador=Lista.get(n-1);
        for(int i=0;i<vel.length;i++){
            aerogerador.setVelocidade(vel[i]);
            PTs[i]=aerogerador.get_Pt();
        }
        return PTs;
    }
    public double AllgetCalcPT(double vel){
        double res=0;
        for (Aerogerador aerogerador : Lista) {
            aerogerador.setVelocidade(vel);
            res += aerogerador.get_Pt();
        }
        return res;
    }
}
