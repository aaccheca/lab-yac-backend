package yavirac.labyac.controller;
import yavirac.labyac.service.*;
import yavirac.labyac.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/registros-laboratorio")
public class RegistroLaboratorioController {

    @Autowired
    private RegistroLaboratorioService registroLaboratorioService;

    @GetMapping
    public ResponseEntity<List<RegistroLaboratorio>> obtenerTodosRegistrosLaboratorio() {
        List<RegistroLaboratorio> registrosLaboratorio = registroLaboratorioService.obtenerTodosRegistrosLaboratorio();
        return new ResponseEntity<>(registrosLaboratorio, HttpStatus.OK);
    }

    @GetMapping("/novedades")
    public ResponseEntity<List<RegistroLaboratorio>> obtenerRegistrosConNovedadesNotNull() {
        List<RegistroLaboratorio> registrosLaboratorio = registroLaboratorioService.obtenerRegistrosConNovedadesNotNull();
        return new ResponseEntity<>(registrosLaboratorio, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroLaboratorio> getRegistroById(@PathVariable Long id) {
        RegistroLaboratorio registro = registroLaboratorioService.getRegistroById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistroLaboratorio> createRegistro(@RequestBody RegistroLaboratorio registro) {
        RegistroLaboratorio createdRegistro = registroLaboratorioService.createRegistro(registro);
        return new ResponseEntity<>(createdRegistro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroLaboratorio> updateRegistro(@PathVariable Long id, @RequestBody RegistroLaboratorio registro) {
        RegistroLaboratorio updatedRegistro = registroLaboratorioService.updateRegistro(id, registro);
        return new ResponseEntity<>(updatedRegistro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        registroLaboratorioService.deleteRegistro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/novedades/{id}")
    public ResponseEntity<?> eliminarNovedad(@PathVariable Long id) {
        registroLaboratorioService.eliminarNovedades(id);
        return ResponseEntity.ok().build();
    }

}
