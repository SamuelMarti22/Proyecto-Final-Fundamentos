import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static BaseDeDatos baseRefugios = new BaseDeDatos("./archivos/refugios.txt");
    public static BaseDeDatos baseAdoptante = new BaseDeDatos("./archivos/adoptantes.txt");
    public static BaseDeDatos datosMascotas = new BaseDeDatos("./archivos/mascotas.txt");
    public static BaseDeDatos baseTransacciones = new BaseDeDatos("./archivos/transacciones.txt");
    public static BaseDeDatos baseSolicitudes = new BaseDeDatos("./archivos/solicitudes.txt");
    private static String nombrePerfil = new String();

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

    // Creación de función "buscarMascota_Refugio" encarga de recorrer la lista d
    // mascotas para buscar coincidencias de nombre dentro de ella para ingresar o
    // no el
    // refugio a la "base de datos"
    public static String buscarMascota_Refugio(ArrayList<Mascota> mascotas, String nombre) {
        int i = 0;
        while (i < mascotas.size()) {
            if (mascotas.get(i).getNombre().equals(nombre)) {
                return mascotas.get(i).getRefugio();
            } else {
                i++;
            }
        }
        return null;
    }

    // Creación de función "buscarAdoptante" encarga de recorrer la lista de
    // adoptantes para buscar coincidencias de nombre dentro de ella para ingresar o
    // no el adoptan a la "base de datos"
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

    public static void imagenesMascotas(String foto) {
        switch (foto) {
            case "1":
                System.out.print("Hola");
                break;

            default:
                break;
        }
    }

    public static void filtrarRaza(ArrayList<Mascota> mascotas, String raza) {
        int i = 0;
        while (i < mascotas.size()) {
            if (mascotas.get(i).getRaza().equals(raza)) {
                System.out.println("Nombre: " + mascotas.get(i).getNombre());
                System.out.println("Raza: " + mascotas.get(i).getRaza());
                System.out.println("Edad: " + mascotas.get(i).getEdad());
                System.out.println("Sexo: " + mascotas.get(i).getGenero());
                System.out.println("Estado de salud: " + mascotas.get(i).getEstadoDeSalud());
                System.out.println("Descripción: " + mascotas.get(i).getDescipcion());
                System.out.println("Refugio: " + mascotas.get(i).getRefugio());
            }
            i++;
        }
    }

    public static void filtrarSexo(ArrayList<Mascota> mascotas, String sexo) {
        int i = 0;
        while (i < mascotas.size()) {
            if (mascotas.get(i).getGenero().equals(sexo)) {
                System.out.println("Nombre: " + mascotas.get(i).getNombre());
                System.out.println("Raza: " + mascotas.get(i).getRaza());
                System.out.println("Edad: " + mascotas.get(i).getEdad());
                System.out.println("Sexo: " + mascotas.get(i).getGenero());
                System.out.println("Estado de salud: " + mascotas.get(i).getEstadoDeSalud());
                System.out.println("Descripción: " + mascotas.get(i).getDescipcion());
                System.out.println("Refugio: " + mascotas.get(i).getRefugio());
            }
            i++;
        }
    }

    public static void filtrarEdad(ArrayList<Mascota> mascotas, int edad) {
        int i = 0;
        while (i < mascotas.size()) {
            if (mascotas.get(i).getEdad() == edad) {
                System.out.println("Nombre: " + mascotas.get(i).getNombre());
                System.out.println("Raza: " + mascotas.get(i).getRaza());
                System.out.println("Edad: " + mascotas.get(i).getEdad());
                System.out.println("Sexo: " + mascotas.get(i).getGenero());
                System.out.println("Estado de salud: " + mascotas.get(i).getEstadoDeSalud());
                System.out.println("Descripción: " + mascotas.get(i).getDescipcion());
                System.out.println("Refugio: " + mascotas.get(i).getRefugio());
            }
            i++;
        }
    }

    // Creación de función "imprimirRefugios" encarga de recorrer la lista de
    // refugio e imprimir su informacipon (Atributos)
    public static void imprimirRefugios(ArrayList<Refugio> refugios) {
        int i = 0;

        while (i < refugios.size()) {
            System.out.println("En el refugio: " + refugios.get(i).getNombre() + ", con direccion: "
                    + refugios.get(i).getDireccion() + " y telefono:  " + refugios.get(i).getTelefono());
            int a = 0;
            while (a < refugios.get(i).getNumeroMascotas()) {
                System.out.println("Tiene las siguientes mascotas:");
                ArrayList<Mascota> mascotas = refugios.get(i).getMascotas();
                System.out.println("Nombre: " + mascotas.get(a).getNombre());
                System.out.println("Raza: " + mascotas.get(a).getRaza());
                System.out.println("Edad: " + mascotas.get(a).getEdad());
                System.out.println("Sexo: " + mascotas.get(a).getGenero());
                System.out.println("Estado de salud: " + mascotas.get(a).getEstadoDeSalud());
                System.out.println("Descripción: " + mascotas.get(a).getDescipcion());
                a++;
            }

            a = 0;
            while (a < refugios.get(i).getNumeroTransacciones()) {
                ArrayList<Transaccion> transacciones = refugios.get(i).getTransacciones();
                System.out.println(transacciones.get(a).getDueno() + "," + transacciones.get(a).getMascota());
                a++;
            }

            i++;
        }
    }

    public static void agregarMascota() {
        ArrayList<Mascota> listaMascotas = datosMascotas.obtenerMascotas();
        System.out.println("Necesitamos más información de nuestro amigo peludo");
        System.out.println("Nombre: ");
        String nombreMascota;
        while (true) {
            int contador = 0;
            nombreMascota = input.nextLine();
            for (int i = 0; i < listaMascotas.size(); i++) {
                if (listaMascotas.get(i).getNombre().equals(nombreMascota)) {
                    System.out.println("Ya existe una mascota con ese nombre, por favor ingrsa otro nombre: ");
                    contador += 1;
                }
            }
            if (contador == 0) {
                break;
            }
        }
        System.out.print("Edad: ");
        int edadNum;
        while (true) {
            String edad = input.nextLine();
            if (esNumero(edad) == true) {
                edadNum = Integer.parseInt(edad);
                break;
            } else {
                System.out.println("No es un numero");
            }
        }
        System.out.println("Raza: ");
        String razaMascota = input.nextLine();
        System.out.println("Genero: ");
        String generoMascota = input.nextLine();
        System.out.println("Estado de salud: ");
        String estadoDeSaludMascota = input.nextLine();
        System.out.println("Foto: ");
        String fotoMascota = input.nextLine();
        System.out.println("Descripción: ");
        String descripcionMascota = input.nextLine();
        Mascota mascota = new Mascota(nombreMascota, razaMascota, edadNum, estadoDeSaludMascota, generoMascota,
                fotoMascota, descripcionMascota, nombrePerfil);
        datosMascotas.agregarMascota(mascota);
    }

    public static void agregarSolicitud() {
        System.out.println("Para realizar la solicitud necesitamos algunos datos...");
        System.out.println("Nombre de la mascota: ");
        ArrayList<Mascota> listaMascotas = datosMascotas.obtenerMascotas();
        String nombreMascota;
        while (true) {
            nombreMascota = input.nextLine();
            if (buscarMascota_Refugio(listaMascotas, nombreMascota) != null) {
                String nombreRefugio = buscarMascota_Refugio(listaMascotas, nombreMascota);
                Solicitud solicitudInsert = new Solicitud(nombrePerfil, nombreMascota, nombreRefugio);
                baseSolicitudes.agregarSolicitud(solicitudInsert);
                break;
            } else {
                System.out.println("No existe una mascota con ese nombre, por favor ingresa otro nombre");
            }
        }
    }

    public static boolean esNumero(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public static void mostrarHistorial() {
        ArrayList<Transaccion> historial = baseTransacciones.obtenerTransacciones();
        for (int i = 0; i < historial.size(); i++) {
            if (historial.get(i).getRefugio().equals(nombrePerfil)) {
                System.out.println("-----------------------------------------");
                System.out.println("Dueño: " + historial.get(i).getDueno());
                System.out.println("Mascota: " + historial.get(i).getMascota());
            }
        }
    }

    public static void mostrarMascotasRefugio() {
        ArrayList<Mascota> mascotas = datosMascotas.obtenerMascotas();
        System.out.println("Tiene las siguientes mascotas:");
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getRefugio().equals(nombrePerfil)) {
                System.out.println("-----------------------------------------");
                System.out.println("Nombre: " + mascotas.get(i).getNombre());
                System.out.println("Raza: " + mascotas.get(i).getRaza());
                System.out.println("Edad: " + mascotas.get(i).getEdad());
                System.out.println("Sexo: " + mascotas.get(i).getGenero());
                System.out.println("Estado de salud: " + mascotas.get(i).getEstadoDeSalud());
                System.out.println("Descripción: " + mascotas.get(i).getDescipcion());
            }
        }
    }

    public static void mostrarSolicitudes() {
        ArrayList<Solicitud> solicitudes = baseSolicitudes.obtenerSolicitudes();
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getRefugio().equals(nombrePerfil)) {
                System.out.println("-----------------------------------------");
                System.out.println("Dueño: " + solicitudes.get(i).getDueno());
                System.out.println("Mascota: " + solicitudes.get(i).getMascota());
            }
        }
    }

    public static void gestionarSolicitudes() {
        ArrayList<Solicitud> solicitudes = baseSolicitudes.obtenerSolicitudes();
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getRefugio().equals(nombrePerfil)) {
                System.out.println("-----------------------------------------");
                System.out.println("Dueño: " + solicitudes.get(i).getDueno());
                System.out.println("Mascota: " + solicitudes.get(i).getMascota());
                System.out.println("Gestion de Solicitudes:");
                System.out.println("1. Aceptar solicitud \n2. Denegar Solicitud \n3. Salir");
                System.out.println("Ingresar opcion");
                int opcion3 = input.nextInt();
                switch (opcion3) {
                    case 1:
                        System.out.println("La solicitud ha sido aceptada");
                        Transaccion transaccionGestion = new Transaccion(solicitudes.get(i).getDueno(),
                                solicitudes.get(i).getMascota(), solicitudes.get(i).getRefugio());
                        baseTransacciones.agregarTransaccion(transaccionGestion);
                        // Funcion para eliminar una solicitd
                        i--;
                        break;
                    case 2:
                        System.out.println("La solicitud ha sido denegada");
                        // Funcion para eliminar una solicitd
                        i--;
                        break;
                    case 3:
                        System.out.println("Cerrar Gestion");
                        i = solicitudes.size() + 1;
                        break;

                    default:
                        break;
                }
            }
        }
    }

    public static void mostrarAdoptantes() {
        ArrayList<Adoptante> adoptantes = baseAdoptante.obtenerAdoptantes();
        for (int i = 0; i < adoptantes.size(); i++) {
            System.out.println("-----------------------------------------");
            System.out.println("Nombre: " + adoptantes.get(i).getNombre());
            System.out.println("Edad: " + adoptantes.get(i).getEdad());
            System.out.println("Telefono: " + adoptantes.get(i).getTelefono());
            System.out.println("Correo: " + adoptantes.get(i).getCorreo());
            System.out.println("Capacidad: " + adoptantes.get(i).getCapacidad());
        }
    }

    public static void mostrarMascotasAdoptantes() {
        ArrayList<Adoptante> adoptantes = baseAdoptante.obtenerAdoptantes();
        for (int i = 0; i < adoptantes.size(); i++) {
            if (adoptantes.get(i).getNombre().equals(nombrePerfil)) {
                System.out.println("Estas son tus mascotas");
                for (int j = 0; j < adoptantes.get(i).getMascotas().size(); j++) {
                    System.out.println(adoptantes.get(j).getMascotas().get(j));
                }
            }
        }
    }

    public static void mostrarSolicitudesAdoptante() {
        ArrayList<Transaccion> listaTransacciones = baseTransacciones.obtenerTransacciones();
        ArrayList<Solicitud> listaSolicitud = baseSolicitudes.obtenerSolicitudes();
        for (int i = 0; i < listaSolicitud.size(); i++) {

            if (listaSolicitud.get(i).getDueno().equals(nombrePerfil)) {
                System.out.println("-----------------------------------------");
                System.out.println("Mascota: " + listaSolicitud.get(i).getMascota() + " Estado: EN REVISIÓN");
            }
        }
        for (int i = 0; i < listaTransacciones.size(); i++) {
            if (listaTransacciones.get(i).getDueno().equals(nombrePerfil)) {
                System.out.println("-----------------------------------------");
                System.out.println("Mascota: " + listaTransacciones.get(i).getMascota() + " Estado: APROVADO");
            }
        }
        System.out.println("Si hiciste una solicitud y no aparece se debe a que fue rechazada");
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
            ArrayList<Refugio> refugios = baseRefugios.obtenerRefugios();
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
                nombrePerfil = nombre;
            } else {
                System.out.println("Ya se encuentra registrado, continuar...");
                nombrePerfil = nombre;
            }
            System.out.println("Menu");
            System.out.print(
                    "1. Ingresar Mascotas \n2. Ver Mascotas \n3. Ver Solicitudes \n4. Hisotorial de Transacciones \n5. Ver registro de adoptantes \n6 Gestionar Solicitudes \7.Salir");
            System.out.print("Ingresa tu opcion: ");
            String opcion = input.nextLine();

            while (opcion != "6") {
                switch (opcion) {
                    case "1":
                        System.out.println("Ingresar mascotas");
                        agregarMascota();
                        break;
                    case "2":
                        System.out.println("Ver mascotas");
                        mostrarMascotasRefugio();
                        break;
                    case "3":
                        System.out.println("Ver solicitudes");
                        mostrarSolicitudes();
                        break;
                    case "4":
                        System.out.println("Historial de transacciones");
                        mostrarHistorial();
                        break;
                    case "5":
                        System.out.println("Ver registro de adoptantes");
                        mostrarAdoptantes();
                        break;
                    case "6":
                        System.out.println("Gestionar Solicitudes");
                        gestionarSolicitudes();
                        break;
                    case "7":
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.print("Ingresa tu opcion: ");
                opcion = input.nextLine();
            }
        } else if (perfil.equals("2")) {
            System.out.println("Bienvenido al portal de Adoptantes");
            System.out.print("Para continuar ingresa el nombre su nombre: ");
            String nombre = input.nextLine();
            ArrayList<Adoptante> adoptantes = baseAdoptante.obtenerAdoptantes();
            Adoptante adoptante = buscarAdoptante(adoptantes, nombre);

            if (adoptante == null) {
                ArrayList<String> mascotas = new ArrayList<String>();
                System.out.println("Ingresar tu información ");
                System.out.print("Nombre: ");
                String nombreAdoptante = input.nextLine();
                System.out.print("Edad: ");
                int edadNum;
                while (true) {
                    String edad = input.nextLine();
                    if (esNumero(edad) == true) {
                        edadNum = Integer.parseInt(edad);
                        break;
                    } else {
                        System.out.println("No es un numero");
                    }
                }
                System.out.print("Telefono: ");
                String telefono = input.nextLine();
                System.out.print("Correo: ");
                String correo = input.nextLine();
                System.out.print("Capacidad: ");
                String capacidad = input.nextLine();
                Adoptante adoptanteInsert = new Adoptante(nombreAdoptante, edadNum, telefono, correo, capacidad,
                        mascotas);
                baseAdoptante.agregarAdoptante(adoptanteInsert);
                nombrePerfil = nombre;
            } else {
                System.out.println("Ya se encuentra registrado, continuar...");
                nombrePerfil = nombre;
            }

            System.out.println("Menu");
            System.out.print(
                    "1. Ver Mascotas de todos los refugios \n2. Enviar Solicitud \n3. Estado Solicitud\n4. Filtrar Informacion \n5. Ver tus mascotas \n6. Salir");
            System.out.print("Ingresa tu opcion: ");
            int opcion = input.nextInt();
            while (opcion != 6) {
                switch (opcion) {
                    case 1:
                        System.out.println("Ver mascotas");
                        ArrayList<Refugio> refugios = baseRefugios.obtenerRefugios();
                        imprimirRefugios(refugios);
                        break;
                    case 2:
                        System.out.println("Enviar Solicitud");
                        agregarSolicitud();
                        break;
                    case 3:
                        System.out.println("Estado solicitudes");
                        mostrarSolicitudesAdoptante();
                        break;
                    case 4:
                        ArrayList<Mascota> mascotas = datosMascotas.obtenerMascotas();
                        System.out.println("Filtrar Informacion");
                        System.out.println("Filtrar por: \n1. Raza \n2. Sexo \n3. Edad ");
                        System.out.print("Ingresa tu opcion: ");
                        int opcion2 = input.nextInt();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingresar la raza a filtrar: ");
                                String raza = input.nextLine();
                                System.out.println("Tras filtar por Raza, este es el resultado: ");
                                filtrarRaza(mascotas, raza);
                                break;
                            case 2:
                                System.out.println("Ingresar la sexo a filtrar (Macho,Hembra): ");
                                String sexo = input.nextLine();
                                System.out.println("Tras filtar por sexo, este es el resultado: ");
                                filtrarSexo(mascotas, sexo);
                                break;
                            case 3:
                                System.out.println("Ingresar la edad a filtrar: ");
                                int edadNum;
                                while (true) {
                                    String edad = input.nextLine();
                                    if (esNumero(edad) == true) {
                                        edadNum = Integer.parseInt(edad);
                                        break;
                                    } else {
                                        System.out.println("No es un numero");
                                    }
                                }
                                System.out.println("Tras filtar por edad, este es el resultado: ");
                                filtrarEdad(mascotas, edadNum);
                        }
                        break;
                    case 5:
                        System.out.println("Ver tus mascotas");
                        mostrarMascotasAdoptantes();
                        break;
                    case 6:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.print("Ingresa tu opcion: ");
                opcion = input.nextInt();
            }
        } else {
            System.out.println("Opcion no valida");
        }
    }
}