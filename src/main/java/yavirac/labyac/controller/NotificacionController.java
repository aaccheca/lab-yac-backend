package yavirac.labyac.controller;
import yavirac.labyac.service.*;
import yavirac.labyac.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> obtenerNotificaciones() {
        List<Notificacion> notificaciones = notificacionService.obtenerNotificaciones();
        return new ResponseEntity<>(notificaciones, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Notificacion>> getNotificacionesByUsuarioId(@PathVariable Long usuarioId) {
        List<Notificacion> notificaciones = notificacionService.getNotificacionesByUsuarioId(usuarioId);
        return new ResponseEntity<>(notificaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtenerNotificacionPorId(@PathVariable Long id) {
        Notificacion notificacion = notificacionService.obtenerNotificacionPorId(id);
        return new ResponseEntity<>(notificacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion nuevoNotificacion = notificacionService.crearNotificacion(notificacion);
        return new ResponseEntity<>(nuevoNotificacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> actualizarNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        Notificacion notificacionActualizado = notificacionService.actualizarNotificacion(id, notificacion);
        return new ResponseEntity<>(notificacionActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        notificacionService.eliminarNotificacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
