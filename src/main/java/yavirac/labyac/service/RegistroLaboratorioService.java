package yavirac.labyac.service;
import yavirac.labyac.entity.*;
import yavirac.labyac.repository.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RegistroLaboratorioService {

    @Autowired
    private RegistroLaboratorioRepository registroLaboratorioRepository;

    public List<RegistroLaboratorio> obtenerTodosRegistrosLaboratorio() {
        return registroLaboratorioRepository.findAll();
    }
    
    public List<RegistroLaboratorio> obtenerRegistrosConNovedadesNotNull() {
        return registroLaboratorioRepository.findAllWithNovedadesNotNull();
    }    

    public RegistroLaboratorio getRegistroById(Long id) {
        return registroLaboratorioRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Registro no encontrado con id: " + id));
    }

    public RegistroLaboratorio createRegistro(RegistroLaboratorio registro) {
        return registroLaboratorioRepository.save(registro);
    }

    public RegistroLaboratorio updateRegistro(Long id, RegistroLaboratorio registro) {
        RegistroLaboratorio registroExistente = getRegistroById(id);
        registroExistente.setUsuario(registro.getUsuario());
        registroExistente.setAula(registro.getAula());
        registroExistente.setFecha(registro.getFecha());
        registroExistente.setHoraIngreso(registro.getHoraIngreso());
        registroExistente.setHoraSalida(registro.getHoraSalida());
        registroExistente.setNovedades(registro.getNovedades());
        registroExistente.setFirma(registro.getFirma());
        registroExistente.setGuardiaTurno(registro.getGuardiaTurno());
        return registroLaboratorioRepository.save(registroExistente);
    }

    public void deleteRegistro(Long id) {
        registroLaboratorioRepository.deleteById(id);
    }

    public void eliminarNovedades(Long id) {
        Optional<RegistroLaboratorio> registroOptional = registroLaboratorioRepository.findById(id);
        if (registroOptional.isPresent()) {
            RegistroLaboratorio registro = registroOptional.get();
            registro.setNovedades(null);
            registroLaboratorioRepository.save(registro);
        }
    }

}
