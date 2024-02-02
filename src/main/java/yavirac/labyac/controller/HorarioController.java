package yavirac.labyac.controller;
import yavirac.labyac.service.*;
import yavirac.labyac.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

     @GetMapping
    public ResponseEntity<List<Horario>> obtenerTodosHorarios() {
        List<Horario> horarios = horarioService.obtenerTodosHorarios();
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtenerHorarioPorId(@PathVariable Long id) {
        Horario horario = horarioService.obtenerHorarioPorId(id);
        return ResponseEntity.ok(horario);
    }

    @PostMapping
    public ResponseEntity<Horario> crearHorario(@RequestBody Horario horario) {
        Horario nuevoHorario = horarioService.crearHorario(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHorario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long id, @RequestBody Horario horario) {
        Horario horarioActualizado = horarioService.actualizarHorario(id, horario);
        return ResponseEntity.ok(horarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long id) {
        horarioService.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }

}
