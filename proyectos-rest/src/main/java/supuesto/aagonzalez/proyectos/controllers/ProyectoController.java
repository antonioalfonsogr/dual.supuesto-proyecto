package supuesto.aagonzalez.proyectos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import supuesto.aagonzalez.proyectos.domain.Proyecto;
import supuesto.aagonzalez.proyectos.domain.service.ProyectoService;

import java.util.List;

@RestController
@RequestMapping("proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping(value = "")
    public List<Proyecto> obtenerProyectos() {
        return proyectoService.obtenerProyectos();
    }

    @PostMapping(value = "")
    public Proyecto insertarProyecto(@RequestBody Proyecto proyecto) {
        return this.proyectoService.insertarProyecto(proyecto);
    }

    @GetMapping(value = "/{id}")
    public Proyecto obtenerProyecto(@PathVariable Long id) {
        return this.proyectoService.obtenerProyecto(id);
    }

    @PutMapping(value = "/{id}")
    public void actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        this.proyectoService.actualizarProyecto(id, proyecto);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarProyecto(@PathVariable Long id) {
        this.proyectoService.eliminarProyecto(id);
    }
}
