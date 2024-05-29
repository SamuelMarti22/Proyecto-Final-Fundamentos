import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BaseDeDatos {
    private String nombreArchivo;

    public BaseDeDatos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    //Devuelve una lista con todas las mascotas en la base de datos
    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Mascota mascota = new Mascota(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], partes[4],
                        partes[5], partes[6], partes[7]);
                mascotas.add(mascota);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mascotas;
    }
    //Devuelve una lista con todos los adoptantes en la base de datos
    public ArrayList<Adoptante> obtenerAdoptantes() {
        ArrayList<Adoptante> adoptantes = new ArrayList<>();
        BaseDeDatos datosTransacciones = new BaseDeDatos("./archivos/transacciones.txt");
        ArrayList<Transaccion> mascotasProv = datosTransacciones.obtenerTransacciones();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ArrayList<String> mascotas = new ArrayList<>();
                String[] partes = linea.split(",");
                for (int i = 0; i < mascotasProv.size(); i++) {
                    if (mascotasProv.get(i).getDueño().equals(partes[0]));
                    mascotas.add(mascotasProv.get(i).getMascota());
                    //Acá busca las mascotas que fueron adoptadas, y agrega las que esten a nombre del adoptante
                }
                Adoptante adoptante = new Adoptante(partes[0], Integer.parseInt(partes[1]), partes[2], partes[3],
                        partes[4], mascotas);
                adoptantes.add(adoptante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adoptantes;
    }
    //Devuelve una lista con todas las trasnsacciones en la base de datos
    public ArrayList<Transaccion> obtenerTransacciones() {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("-");
                Transaccion transaccion = new Transaccion(partes[0], partes[1], partes[2]);
                transacciones.add(transaccion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transacciones;
    }
    //Devuelve una lista con todas las solicitudes
    public ArrayList<Solicitud> obtenerSolicitudes() {
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                Solicitud solicitud = new Solicitud(partes[0], partes[1], partes[2]);
                solicitudes.add(solicitud);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }
    //Devuelve una lista con todos los refugios
    public ArrayList<Refugio> obtenerRefugios() {
        ArrayList<Refugio> refugios = new ArrayList<Refugio>();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            BaseDeDatos datosMascotas = new BaseDeDatos("./archivos/mascotas.txt");
            BaseDeDatos datosAdoptantes = new BaseDeDatos("./archivos/solicitudes.txt");
            BaseDeDatos datosTransaccion = new BaseDeDatos("./archivos/transacciones.txt");
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                ArrayList<Mascota> mascotas = datosMascotas.obtenerMascotas();
                mascotas = filtrarMascotas(mascotas, datos[0]);
                ArrayList<Transaccion> transacciones = datosTransaccion.obtenerTransacciones();
                transacciones = filtrarTransacciones(transacciones, datos[0]);
                ArrayList<Solicitud> adoptantes = datosAdoptantes.obtenerSolicitudes();
                adoptantes = filtrarAdoptantes(adoptantes, datos[0]);
                Refugio refugio = new Refugio(datos[0], datos[1], datos[2], mascotas, adoptantes, transacciones);
                refugios.add(refugio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return refugios;
    }
    //Filtra las mascotas según el refugio
    public ArrayList<Mascota> filtrarMascotas(ArrayList<Mascota> mascotas, String nombreRefugio) {
        int i = 0;
        ArrayList<Mascota> mascotasFiltradas = new ArrayList<Mascota>();
        while (i < mascotas.size()) {
            if (mascotas.get(i).getRefugio().equals(nombreRefugio)) {
                mascotasFiltradas.add(mascotas.get(i));
            }
            i++;
        }
        return mascotasFiltradas;
    }
    //Filtra las transacciones según el refugio
    public ArrayList<Transaccion> filtrarTransacciones(ArrayList<Transaccion> transacciones, String nombreRefugio) {
        int i = 0;
        ArrayList<Transaccion> transaccionesFiltradas = new ArrayList<Transaccion>();
        while (i < transacciones.size()) {
            if (transacciones.get(i).getRefugio().equals(nombreRefugio)) {
                transaccionesFiltradas.add(transacciones.get(i));
            }
            i++;
        }
        return transaccionesFiltradas;
    }
    //Filtra los Adoptantes según el refugio al que solicitaron adoptar
    public ArrayList<Solicitud> filtrarAdoptantes(ArrayList<Solicitud> solicitudes, String nombreRefugio) {
        ArrayList<Solicitud> solicitudesN = new ArrayList<>();
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getRefugio().equals(nombreRefugio)) {
                solicitudesN.add(solicitudes.get(i));
            }
        }
        return solicitudesN;
    }
    //Agrega Mascotas a la base de datos
    public void agregarMascota(Mascota mascota) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true);
                BufferedWriter bw = new BufferedWriter(writer);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(mascota.getNombre() + "," + mascota.getRaza() + "," + mascota.getEdad() + ","
                    + mascota.getEstadoDeSalud() + "," + mascota.getGenero() + "," + mascota.getFoto());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Agrega refugios a la base de datos
    public void agregarRefugio(Refugio refugio) {
        try (PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, true)))) {
            escritor.println(refugio.getNombre() + "," + refugio.getDireccion() + "," + refugio.getTelefono());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Agrega solicitudes a la base de datos
    public void agregarSolicitud(Solicitud solicitud) {
        try (PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, true)))) {
            escritor.println(solicitud.getDueno() + "," + solicitud.getMascota() + "," + solicitud.getRefugio());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Agrega adoptantes a la base de datos
    public void agregarAdoptante(Adoptante adoptante){
        try (PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, true)))) {
            escritor.println(adoptante.getNombre() + "," + adoptante.getEdad() + "," + adoptante.getTelefono()+","+adoptante.getCorreo()+","+adoptante.getCapacidad());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Agrega trnasacciones a la base de datos
    public void agregarTransaccion(Transaccion Transaccion){
        try (PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, true)))) {
            escritor.println(Transaccion.getMascota() + "," + Transaccion.getDueño() + "," + Transaccion.getRefugio());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}