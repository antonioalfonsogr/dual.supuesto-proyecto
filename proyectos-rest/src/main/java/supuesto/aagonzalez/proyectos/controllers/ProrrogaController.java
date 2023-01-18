package supuesto.aagonzalez.proyectos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import supuesto.aagonzalez.proyectos.domain.Prorroga;
import supuesto.aagonzalez.proyectos.domain.service.ProyectoService;
import supuesto.aagonzalez.proyectos.domain.service.ProrrogaService;


import java.util.List;

@RestController
@RequestMapping("/proyectos/{idProyecto}/prorrogas")
public class ProrrogaController {

    private final ProrrogaService prorrogaService;
    private final ProyectoService proyectoService;

    @Autowired
    public ProrrogaController(ProrrogaService prorrogaService, ProyectoService proyectoService) {
        this.prorrogaService = prorrogaService;
        this.proyectoService = proyectoService;
    }

    @GetMapping(value = "")
    public List<Prorroga> obtenerProrrogas(@PathVariable(name = "idProyecto") Long idProyecto) {
        return proyectoService.obtenerProyecto(idProyecto).getProrrogas();
    }

    @PostMapping(value = "")
    public Prorroga insertarProrroga(@PathVariable(name = "idProyecto") Long idProyecto, @RequestBody Prorroga prorroga) {
        return this.prorrogaService.insertarProrroga(idProyecto, prorroga);
    }

    @GetMapping(value = "/{id}")
    public Prorroga obtenerProrroga(@PathVariable(name = "id") String id) {
        return this.prorrogaService.obtenerProrroga(Long.valueOf(id));
    }

    @PutMapping(value = "/{id}")
    public void actualizarProrroga(@PathVariable(name = "id") Long id, @RequestBody Prorroga prorroga) {
        this.prorrogaService.actualizarProrroga(id, prorroga);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarProrroga(@PathVariable(name = "id") Long id) {
        this.prorrogaService.eliminarProrroga(id);
    }

}
