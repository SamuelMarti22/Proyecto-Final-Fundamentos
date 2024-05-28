import java.util.ArrayList;

public class Refugio {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Adoptante> adoptantes;
    private ArrayList<Transaccion> transacciones;

    // Constructor
    public Refugio(String nombre, String direccion, String telefono, ArrayList<Mascota> mascotas,
            ArrayList<Adoptante> adoptantes, ArrayList<Transaccion> transacciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mascotas = mascotas;
        this.adoptantes = adoptantes;
        this.transacciones = transacciones;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public int getNumeroMascotas() {
        return mascotas.size();
    }

    public ArrayList<Adoptante> getAdoptantes() {
        return adoptantes;
    }

    public void setAdoptantes(ArrayList<Adoptante> adoptantes) {
        this.adoptantes = adoptantes;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void anadirMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    public void anadirAdoptante(Adoptante adoptante) {
        this.adoptantes.add(adoptante);
    }

    public void anadirTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
    }
}
