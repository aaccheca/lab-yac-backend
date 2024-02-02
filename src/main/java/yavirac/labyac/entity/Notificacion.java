package yavirac.labyac.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    @ManyToOne
    @JoinColumn(name = "id_maestro")
    private Usuario maestro;

    @Column(name = "notificacion")
    private String notificacion;

    // Getters y Setters

    public Long getId() {
        return this.idNotificacion;
    }

    public void setId(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Usuario getMaestro() {
        return this.maestro;
    }

    public void setMaestro(Usuario maestro) {
        this.maestro = maestro;
    }

    public String getNotificacion() {
        return this.notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }
    
}
