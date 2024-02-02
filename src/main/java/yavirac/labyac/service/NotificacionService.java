package yavirac.labyac.service;
import yavirac.labyac.entity.*;
import yavirac.labyac.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    @Autowired
    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public List<Notificacion> getNotificacionesByUsuarioId(Long usuarioId) {
        return notificacionRepository.findNotificacionesByUsuarioId(usuarioId);
    }

    public List<Notificacion> obtenerNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Notificacion obtenerNotificacionPorId(Long id) {
        return notificacionRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Notificacion no encontrada con id: " + id));
    }


    public Notificacion crearNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizarNotificacion(Long id, Notificacion notificacionActualizado) {
        Notificacion notificacionExistente = obtenerNotificacionPorId(id);
        notificacionExistente.setMaestro(notificacionActualizado.getMaestro());
        notificacionExistente.setNotificacion(notificacionActualizado.getNotificacion());
        return notificacionRepository.save(notificacionExistente);
    }

    public void eliminarNotificacion(Long id) {
        Notificacion notificacionExistente = obtenerNotificacionPorId(id);
        notificacionRepository.delete(notificacionExistente);
    }
}
