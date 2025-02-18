package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping()
public class MateriaController {

    @Autowired
    private MateriaService materiaService;
    
    //CREAR MATERIA
    @PostMapping("/materia")
    public ResponseEntity<Materia> crearMateria(@RequestBody MateriaDto materiaDto) throws IllegalArgumentException {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.crearMateria(materiaDto));
    }

    //MODIFICAR MATERIA BUSCANDOLA POR SU ID
    @PutMapping("/materia/{idMateria}")
    public ResponseEntity<Materia> modificarMateria(@PathVariable Integer idMateria, @RequestBody MateriaDto materiaDto) throws MateriaNotFoundException, IllegalArgumentException {
        return ResponseEntity.ok(materiaService.modificarMateria(idMateria,materiaDto));
    }

    //ELIMINAR MATERIA BUSCANDOLA POR SU ID
    @DeleteMapping("/materia/{idMateria}")
    public ResponseEntity<Void> eliminarMateria(@PathVariable Integer idMateria) throws MateriaNotFoundException {
        materiaService.eliminarMateria(idMateria);
        return ResponseEntity.noContent().build();
    }

    //OBTENER MATERIA POR ID
    @GetMapping("/materia/{idMateria}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Integer idMateria) throws MateriaNotFoundException {
        return ResponseEntity.ok(materiaService.getMateriaById(idMateria));
    }

    //OBTENER MATERIAS POR NOMBRE

    @GetMapping("/materia")
    public ResponseEntity<List<Materia>> getMateriasByNombre(@RequestParam String nombre) throws MateriaNotFoundException {
        return ResponseEntity.ok(materiaService.getMateriaByNombre(nombre));
    }

    //OBTENER MATERIAS POR NOMBRE y CODIGO
    @GetMapping("/materias")
    public ResponseEntity<List<Materia>> getMateriasByNombreYCodigo(@RequestParam String ordenNombre, @RequestParam String ordenCodigo) {
        return ResponseEntity.ok(materiaService.getMateriaByNombreYCodigo(ordenNombre, ordenCodigo));

    }




}
