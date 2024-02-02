package yavirac.labyac.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registros_laboratorio")
public class RegistroLaboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora_ingreso")
    private String horaIngreso;

    @Column(name = "hora_salida")
    private String horaSalida;

    @Column(name = "novedades")
    private String novedades;

    @Column(name = "firma")
    private String firma;

    @Column(name = "guardia_turno")
    private String guardiaTurno;

    // Getters y Setters

    public Long getId() {
        return idRegistro;
    }

    public void setId(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getGuardiaTurno() {
        return guardiaTurno;
    }

    public void setGuardiaTurno(String guardiaTurno) {
        this.guardiaTurno = guardiaTurno;
    }
}
