package supuesto.aagonzalez.proyectos.domain.service;

import supuesto.aagonzalez.proyectos.domain.Prorroga;

import java.util.List;

public interface ProrrogaService {

    Prorroga insertarProrroga(Long idProyecto, Prorroga prorroga);

    List<Prorroga> obtenerProrrogas(Long idProyecto);

    Prorroga obtenerProrroga(Long idProrroga);

    void actualizarProrroga(Long idProrroga, Prorroga prorroga);

    void eliminarProrroga(Long idProrroga);
}
