package supuesto.aagonzalez.proyectos.domain.repository;

import supuesto.aagonzalez.proyectos.domain.Prorroga;

import java.util.List;
import java.util.Optional;

public interface ProrrogaRepository {

    List<Prorroga> obtenerProrrogas(Long idProyecto);

    Optional<Prorroga> obtenerProrroga(Long idProrroga);

    Prorroga insertarProrroga(Long idProyecto, Prorroga prorroga);

    void actualizarProrroga(Long idProrroga, Prorroga prorroga);

    void eliminarProrroga(Long idProrroga);


}
