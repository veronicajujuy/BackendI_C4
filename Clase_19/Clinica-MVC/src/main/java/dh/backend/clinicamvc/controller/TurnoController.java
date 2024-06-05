package dh.backend.clinicamvc.controller;

import dh.backend.clinicamvc.model.Paciente;
import dh.backend.clinicamvc.model.Turno;
import dh.backend.clinicamvc.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<Turno> agregarTurno(@RequestBody Turno turno){
        Turno turnoADevolver = turnoService.registrar(turno);
        if(turnoADevolver==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(turnoADevolver);
        }
    }
    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodosTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }
    @PutMapping
    public ResponseEntity<String> modificarTurno(@RequestBody Turno turno){
        turnoService.actualizarTurno(turno);
        return ResponseEntity.ok("Turno modificado");
    }

}
