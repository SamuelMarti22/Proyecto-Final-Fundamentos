public class Transaccion {
    private String mascota;
    private String dueño;
    private String refugio;

    public Transaccion(String mascota, String dueño, String refugio) {
        this.mascota = mascota;
        this.dueño = dueño;
        this.refugio = refugio;
    }

    // Getters
    public String getMascota() {
        return mascota;
    }

    public String getDueño() {
        return dueño;
    }

    public String getRefugio() {
        return refugio;
    }

    // Setters
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public void setRefugio(String refugio) {
        this.refugio = refugio;
    }
}