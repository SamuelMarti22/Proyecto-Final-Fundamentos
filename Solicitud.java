public class Solicitud {
    private String dueno;
    private String mascota;
    private String refugio;

    public Solicitud(String dueno, String mascota, String refugio) {
        this.dueno = dueno;
        this.mascota = mascota;
        this.refugio = refugio;
    }

    // Getters
    public String getDueno() {
        return dueno;
    }

    public String getMascota() {
        return mascota;
    }

    public String getRefugio() {
        return refugio;
    }

    // Setters
    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public void setRefugio(String refugio) {
        this.refugio = refugio;
    }
}
