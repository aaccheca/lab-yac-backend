package yavirac.labyac.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "id_maestro")
    private Usuario maestro;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    // Getters y Setters

    public Long getId() {
        return idHorario;
    }

    public void setId(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Usuario getMaestro() {
        return maestro;
    }

    public void setMaestro(Usuario maestro) {
        this.maestro = maestro;
    }

    public String getDia() {
        return diaSemana;
    }

    public void setDia(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
