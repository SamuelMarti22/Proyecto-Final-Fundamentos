public class Transaccion {
    private Mascota mascota;
    private Adoptante dueño;
    private Refugio refugio;

    public Transaccion(Mascota mascota, Adoptante dueño, Refugio refugio) {
        this.mascota = mascota;
        this.dueño = dueño;
        this.refugio = refugio;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Adoptante getDueño() {
        return dueño;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void setDueño(Adoptante dueño) {
        this.dueño = dueño;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }
}