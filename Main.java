import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    // Creación de función "buscarRefigio" encarga de recorrer la lista de refugios
    // para buscar coincidencias de nombre dentro de ella para ingresar o no el
    // refugio a la "base de datos"
    public static Refugio buscarRefugio(ArrayList<Refugio> refugios, String nombre) {
        int i = 0;
        while (i < refugios.size()) {
            if (refugios.get(i).getNombre().equals(nombre)) {
                Refugio refugio = refugios.get(i);
                System.out.println("Si existe");
                return refugio;
            } else {
                i++;
            }
        }
        return null;
    }

    public static void agregarRefugio() {

    }

    public static void imprimirRefugios(ArrayList<Refugio> refugios, String nombre) {
        int i = 0;

        while (i < refugios.size()) {
            System.out.println(refugios.get(i).getNombre() + ", " + refugios.get(i).getDireccion() + ", "
                    + refugios.get(i).getTelefono());
            int a = 0;
            while (a < refugios.get(i).getNumeroMascotas()) {
                ArrayList<Mascota> mascotas = refugios.get(i).getMascotas();
                System.out.println(mascotas.get(a).getNombre() + ", " + mascotas.get(a).getRaza() + ","
                        + mascotas.get(a).getEdad() + ", " + mascotas.get(a).getGenero() + ", "
                        + mascotas.get(a).getEstadoDeSalud() + "," + mascotas.get(a).getFoto() + ","
                        + mascotas.get(a).getDescipcion());
                a++;
            }

            a = 0;
            while (a < refugios.get(i).getNumeroTransacciones()) {
                ArrayList<Transaccion> transacciones = refugios.get(i).getTransacciones();
                System.out.println(transacciones.get(a).getDueño() + "," + transacciones.get(a).getMascota());
                a++;
            }

            i++;
        }
    }

    public static void ingresarMascota() {

    }

    public static void main(String[] args) {

        System.out.println("Bienvenidos al portal de adopción de mascotas");
        System.out.println("Antes de ingresar, escoger tu perfil");
        System.out.print("1. Refugio      2. Adoptante:  Ingresa tu opcion: ");
        int perfil = input.nextInt();

        if (perfil == 1) {
            System.out.println("Bienvenido al portal de refucios");
            // System.out.println("Para continuar ingresa el nombre del refugio: ");
            String nombre = input.nextLine();
            BaseDeDatos baseRefugios = new BaseDeDatos("./archivos/refugios.txt");
            ArrayList<Refugio> refugios = baseRefugios.obtenerRefugios();
            imprimirRefugios(refugios, nombre);
            Refugio refugio = buscarRefugio(refugios, nombre);
            if (refugio == null) {
                System.out.print("Ingresar información del refugio");
            }

        }
    }
}
