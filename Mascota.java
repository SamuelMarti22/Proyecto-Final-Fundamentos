public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    private String estadoDeSalud;
    private String genero;
    private String foto;
    private String descripcion;
    private String refugio;

    public Mascota(String nombre, String raza, int edad, String estadoDeSalud, String genero, String foto,
            String descripcion, String refugio) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.estadoDeSalud = estadoDeSalud;
        this.genero = genero;
        this.foto = foto;
        this.descripcion = descripcion;
        this.refugio = refugio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public String getGenero() {
        return genero;
    }

    public String getFoto() {
        return foto;
    }

    public String getDescipcion() {
        return descripcion;
    }

    public String getRefugio() {
        return refugio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoDeSalud(String estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setDescipcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRefugio(String refugio) {
        this.refugio = refugio;
    }

}