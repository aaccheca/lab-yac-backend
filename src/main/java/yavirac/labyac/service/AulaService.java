package yavirac.labyac.service;
import yavirac.labyac.entity.*;
import yavirac.labyac.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public List<Aula> obtenerTodasAulas() {
        return aulaRepository.findAll();
    }

    public Aula obtenerAulaPorId(Long id) {
        return aulaRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Aula no encontrada con id: " + id));
    }

    public Aula crearAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Aula actualizarAula(Long id, Aula aula) {
        Aula aulaExistente = obtenerAulaPorId(id);
        aulaExistente.setNombre(aula.getNombre());
        aulaExistente.setEstado(aula.getEstado());
        return aulaRepository.save(aulaExistente);
    }

    public void eliminarAula(Long id) {
        Aula aula = obtenerAulaPorId(id);
        aulaRepository.delete(aula);
    }
    

}
