import java.util.ArrayList;

public class Parque_Eolico{
    public static ArrayList<String> Lista= new ArrayList<String>();
    public static void setInfo(){
        Aerogerador aerogerador=new Aerogerador();
        String convertToString=aerogerador.convertString();
        Lista.add(convertToString);
    }
    public static void getOne(){
        System.out.println(Lista.get(0));
    }
}
