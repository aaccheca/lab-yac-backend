package yavirac.labyac.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aulas")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAula;

    @Column(name = "nombre_aula")
    private String nombreAula;

    @Column(name = "estado")
    private Boolean estado;

    // Getters y Setters

    public Long getId() {
        return this.idAula;
    }

    public void setId(Long idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return this.nombreAula;
    }

    public void setNombre(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
