import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Taller01Sismos {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("[1] Ingresar datos\n" + //listo
                "[2] Mostrar sismo de mayor magnitud\n" +//listo
                "[3] Contar sismos (mayores/igual a 5.0)\n" +//listo
                "[4] Enviar SMS (mayores/igual a 7.0)\n" +//listo
                "[5] Salir\n");

        //System.out.println("opcion: "+elegirOpcion());
        double []datos  = ingresarSismos(crearArreglo());
        mostrarSismos(datos);
        mostrarDouble(buscarMayorSismo(datos));
        mostrarInt(contarSismos(datos,5.0));
        enviarSMS(contarSismos(datos,7.0));
    }

    public static int elegirOpcion() throws IOException {
        System.out.println("ingrese la opcion");
        String num = br.readLine();
        while(!validarSeaNumero(num)){
            System.out.println(num+" --> Error!");
            num = br.readLine();
        }
        if(limiteOpcion(1, 5, num)){
            num = String.valueOf(elegirOpcion());
        }
        return Integer.parseInt(num);
    }

    public static boolean limiteOpcion(int min, int max, String num) {
        int opcion = Integer.parseInt(num);
        return (opcion < min || opcion > max);
    }

    public static boolean validarSeaNumero(String num){
        try{
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException d){
            return false;
        }
    }

    public static void opcionesMenu(int opcion){
        double[] sismos;
        switch (opcion){
            case 1://Ingresar datos
                sismos  = ingresarSismos(crearArreglo());
                break;
            case 2://Mostrar sismo de mayor magnitud
                if (){

                }
                break;
            case 3://Contar sismos (mayores/igual a 5.0)
                break;
            case 4://Enviar SMS (mayores/igual a 7.0)
                break;
            case 5://Salir
                break;
            }
    }

    public static boolean validarSismosVacio(double[] sismos){
        return sismos[0]>0;
    }

    public static void arregloVacio(double[] sismos){

    }

    public static double []crearArreglo(){
        return new double[70];
    }

    public static double[] ingresarSismos(double []sismos){
        for (int i = 0; i < sismos.length; i++) {
            sismos[i] = Math.floor((Math.random() * 10) * 10) / 10;
        }
        return sismos;
    }

    public static void mostrarSismos(double[] sismos) {
        System.out.println(Arrays.toString(sismos));
    }

    public static double buscarMayorSismo(double[] sismos){
        double mayor = -1.0;
        for (double sismo : sismos) {
            if (sismo > mayor) {
                mayor = sismo;
            }
        }
        return  mayor;
    }

    public static void mostrarDouble(double num){
        System.out.println(num);
    }

    public static void mostrarInt(int num){
        System.out.println(num);
    }

    public static int contarSismos( double [] sismos, double gradoSismo){
        int     j = 0;
        for (double sismo : sismos) {
            if (sismo >= gradoSismo) {
                j++;
            }
        }
        return j;
    }

    public static void enviarSMS(int cantidad){
        System.out.println("Alerta!!! se debe evacuar zona costera!     \n"+
                "***** Se han registrado: "+cantidad+" alertas de sismos mayores/iguales a 7.0");
        //hice lo del contador ya que al llenar el arreglo por probabilidad aproximadamente son mas de 15 datos>=7.0
    }
}
