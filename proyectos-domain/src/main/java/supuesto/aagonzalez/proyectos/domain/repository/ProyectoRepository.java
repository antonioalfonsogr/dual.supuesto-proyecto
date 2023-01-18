package supuesto.aagonzalez.proyectos.domain.repository;

import supuesto.aagonzalez.proyectos.domain.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoRepository {

    List<Proyecto> obtenerProyecto();

    Optional<Proyecto> obtenerProyecto(Long idProyecto);

    Proyecto insertarProyecto(Proyecto proyecto);

    void actualizarProyecto(Long idProyecto, Proyecto proyecto);

    void eliminarProyecto(Long idProyecto);

}
