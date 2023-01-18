package supuesto.aagonzalez.proyectos.domain.service;

import supuesto.aagonzalez.proyectos.domain.Proyecto;

import java.util.List;

public interface ProyectoService {

    Proyecto insertarProyecto(Proyecto proyecto);

    List<Proyecto> obtenerProyectos();

    Proyecto obtenerProyecto(Long idProyecto);

    void actualizarProyecto(Long idProyecto, Proyecto proyecto);


    void eliminarProyecto(Long idProyecto);
}

