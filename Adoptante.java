import java.util.ArrayList;

public class Adoptante {

    private String nombre;
    private int edad;
    private String telefono;
    private String correo;
    private String capacidad;
    private ArrayList<String> ListaMascotas;// Lista de las mascotas que tiene adoptadas cada adoptante

    public Adoptante(String nombre, int edad, String telefono, String correo, String capacidad,
            ArrayList<String> ListaMascota) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.capacidad = capacidad;
        this.ListaMascotas = ListaMascota;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    // Getters

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getCapacidad() {
        return this.capacidad;
    }

    public void actualizarListaMascotas(String mascota) {
        this.ListaMascotas.add(mascota);
    }

    public ArrayList<String> getMascotas() {
        return this.ListaMascotas;
    }
}
