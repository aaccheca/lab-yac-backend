package yavirac.labyac.controller;
import yavirac.labyac.service.*;
import yavirac.labyac.entity.*;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

     @GetMapping
    public ResponseEntity<List<Aula>> obtenerTodasAulas() {
        List<Aula> aulas = aulaService.obtenerTodasAulas();
        return new ResponseEntity<>(aulas, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Aula> obtenerAulaPorId(@PathVariable Long id) {
        Aula aula = aulaService.obtenerAulaPorId(id);
        return ResponseEntity.ok(aula);
    }

    @PostMapping
    public ResponseEntity<Aula> crearAula(@RequestBody Aula aula) {
        Aula nuevaAula = aulaService.crearAula(aula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> actualizarAula(@PathVariable Long id, @RequestBody Aula aula) {
        Aula aulaActualizada = aulaService.actualizarAula(id, aula);
        return ResponseEntity.ok(aulaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAula(@PathVariable Long id) {
        aulaService.eliminarAula(id);
        return ResponseEntity.noContent().build();
    }

}
