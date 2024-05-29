import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    private static String nombre = new String();

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

    // Creación de función "buscarAdoptante" encarga de recorrer la lista de
    // adoptantes para buscar coincidencias de nombre dentro de ella para ingresar o
    // no el
    // adoptan a la "base de datos"
    public static Adoptante buscarAdoptante(ArrayList<Adoptante> adoptantes, String nombre) {
        int i = 0;
        while (i < adoptantes.size()) {
            if (adoptantes.get(i).getNombre().equals(nombre)) {
                Adoptante adoptante = adoptantes.get(i);
                System.out.println("Si existe");
                return adoptante;
            } else {
                i++;
            }
        }
        return null;
    }

    // Creación de función "imprimirRefugios" encarga de recorrer la lista de
    // refugio
    // e imprimir su informacipon (Atributos)
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

    public static void main(String[] args) {

        System.out.println("Bienvenidos al portal de adopción de mascotas");
        System.out.println("Antes de ingresar, escoger tu perfil");
        System.out.print("1. Refugio      2. Adoptante:  Ingresa tu opcion: ");
        String perfil = input.nextLine();

        if (perfil.equals("1")) {
            System.out.println("Bienvenido al portal de refugios");
            System.out.print("Para continuar ingresa el nombre del refugio: ");
            String nombre = input.nextLine();
            BaseDeDatos baseRefugios = new BaseDeDatos("./archivos/refugios.txt");
            ArrayList<Refugio> refugios = baseRefugios.obtenerRefugios();
            imprimirRefugios(refugios, nombre);
            Refugio refugio = buscarRefugio(refugios, nombre);
            if (refugio == null) {
                ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
                ArrayList<Solicitud> adoptantes = new ArrayList<Solicitud>();
                ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
                System.out.println("Ingresar información del refugio");
                System.out.print("Nombre: ");
                String nombreRefugio = input.nextLine();
                System.out.print("Dirección: ");
                String direccion = input.nextLine();
                System.out.print("Telefono: ");
                String telefono = input.nextLine();
                Refugio refugioInsert = new Refugio(nombreRefugio, direccion, telefono, mascotas, adoptantes,
                        transacciones);
                baseRefugios.agregarRefugio(refugioInsert);
            } else {
                System.out.println("Ya se encuentra registrado, continuar...");
            }
            System.out.println("Menu");
            System.out.print(
                    "1. Ingresar Mascotas \n2. Ver Mascotas \n3. Ver Solicitudes \n4. Hisotorial de Transacciones \n5. Salir");
            System.out.print("Ingresa tu opcion: ");
            int opcion = input.nextInt();

            while (opcion != 5) {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresar mascotas");
                        break;
                    case 2:
                        System.out.println("Ver mascotas");
                        break;
                    case 3:
                        System.out.println("Ver solicitudes");
                        break;
                    case 4:
                        System.out.println("Historial de transacciones");
                        break;
                    case 5:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.print("Ingresa tu opcion: ");
                opcion = input.nextInt();
            }
        } else if (perfil.equals("2")) {
            System.out.println("Bienvenido al portal de Adoptantes");
            System.out.print("Para continuar ingresa el nombre su nombre: ");
            String nombre = input.nextLine();
            BaseDeDatos baseAdoptante = new BaseDeDatos("./archivos/adoptantes.txt");
            ArrayList<Adoptante> adoptantes = baseAdoptante.obtenerAdoptantes();
            Adoptante adoptante = buscarAdoptante(adoptantes, nombre);

            if (adoptante == null) {
                ArrayList<String> mascotas = new ArrayList<String>();
                System.out.println("Ingresar tu información ");
                System.out.print("Nombre: ");
                String nombreAdoptante = input.nextLine();
                System.out.print("Edad: ");
                int edad = input.nextInt();
                System.out.println("\nTelefono: ");
                String telefono = input.nextLine();
                System.out.print("Correo: ");
                String correo = input.nextLine();
                System.out.print("Capacidad: ");
                String capacidad = input.nextLine();
            }
        } else {
            System.out.println("Opcion no valida");
        }
    }
}