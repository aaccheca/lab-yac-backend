package yavirac.labyac.service;
import yavirac.labyac.entity.*;
import yavirac.labyac.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> obtenerTodosHorarios() {
        return horarioRepository.findAll();
    }

    public Horario obtenerHorarioPorId(Long id) {
        return horarioRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Horario no encontrado con id: " + id));
    }

    public Horario crearHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario actualizarHorario(Long id, Horario horario) {
        Horario horarioExistente = obtenerHorarioPorId(id);
        horarioExistente.setAula(horario.getAula());
        horarioExistente.setMaestro(horario.getMaestro());
        horarioExistente.setDia(horario.getDia());
        horarioExistente.setHoraInicio(horario.getHoraInicio());
        horarioExistente.setHoraFin(horario.getHoraFin());
        return horarioRepository.save(horarioExistente);
    }

    public void eliminarHorario(Long id) {
        horarioRepository.deleteById(id);
    }

}
