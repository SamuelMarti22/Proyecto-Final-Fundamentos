import java.io.*;
import java.util.ArrayList;

public class BaseDeDatos {
    private String nombreArchivo;

    public BaseDeDatos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

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

    public ArrayList<Adoptante> obtenerAdoptantes() {
        ArrayList<Adoptante> adoptantes = new ArrayList<>();
        BaseDeDatos datosMascotas = new BaseDeDatos("./archivos/mascotas.txt");
        ArrayList<Mascota> mascotasProv = datosMascotas.obtenerMascotas();
        ArrayList<Mascota> mascotas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Adoptante adoptante = new Adoptante(partes[0], Integer.parseInt(partes[1]), partes[2], partes[3],
                        partes[4], mascotas);
                adoptantes.add(adoptante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adoptantes;
    }

    public ArrayList<Refugio> obtenerRefugios() {
        ArrayList<Refugio> refugios = new ArrayList<Refugio>();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            BaseDeDatos datosMascotas = new BaseDeDatos("./archivos/mascotas.txt");
            ArrayList<Mascota> mascotas = datosMascotas.obtenerMascotas();
            BaseDeDatos datosAdoptantes = new BaseDeDatos("./archivos/adoptantes.txt");
            ArrayList<Adoptante> adoptantes = new ArrayList<>();
            BaseDeDatos datosTransaccion = new BaseDeDatos("./archivos/transacciones.txt");
            ArrayList<Transaccion> transacciones = new ArrayList<>();
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                Refugio refugio = new Refugio(datos[0], datos[1], datos[2], mascotas, adoptantes, transacciones);
                refugios.add(refugio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return refugios;
    }
}