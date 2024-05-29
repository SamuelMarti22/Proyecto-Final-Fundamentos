public class Transaccion {
    private String mascota;
    private String dueno;
    private String refugio;

    public Transaccion(String mascota, String dueno, String refugio) {
        this.mascota = mascota;
        this.dueno = dueno;
        this.refugio = refugio;
    }

    // Getters
    public String getMascota() {
        return mascota;
    }

    public String getDueno() {
        return dueno;
    }

    public String getRefugio() {
        return refugio;
    }

    // Setters
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public void setRefugio(String refugio) {
        this.refugio = refugio;
    }
}