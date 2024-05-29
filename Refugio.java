import java.util.ArrayList;

public class Refugio {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Solicitud> solicitudesAdoptantes;
    private ArrayList<Transaccion> transacciones;

    // Constructor
    public Refugio(String nombre, String direccion, String telefono, ArrayList<Mascota> mascotas,
            ArrayList<Solicitud> solicitudesAdoptantes, ArrayList<Transaccion> transacciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mascotas = mascotas;
        this.solicitudesAdoptantes = solicitudesAdoptantes;
        this.transacciones = transacciones;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumeroMascotas() {
        return mascotas.size();
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public ArrayList<Solicitud> getAdoptantes() {
        return solicitudesAdoptantes;
    }

    public int getNumeroTransacciones() {
        return transacciones.size();
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setAdoptantes(ArrayList<Solicitud> adoptantes) {
        this.solicitudesAdoptantes = adoptantes;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void anadirMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    public void anadirAdoptante(Solicitud adoptante) {
        this.solicitudesAdoptantes.add(adoptante);
    }

    public void anadirTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
    }
}
