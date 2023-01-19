package supuesto.aagonzalez.proyectos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supuesto.aagonzalez.proyectos.domain.Prorroga;
import supuesto.aagonzalez.proyectos.domain.Proyecto;
import supuesto.aagonzalez.proyectos.domain.repository.ProrrogaRepository;
import supuesto.aagonzalez.proyectos.domain.repository.ProyectoRepository;
import supuesto.aagonzalez.proyectos.domain.service.ProrrogaService;

import java.util.List;
import java.util.Optional;

@Service
public class ProrrogaSeviceImpl implements ProrrogaService {

    private final ProrrogaRepository prorrogaRepository;

    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProrrogaSeviceImpl(ProrrogaRepository prorrogaRepository, ProyectoRepository proyectoRepository) {
        this.prorrogaRepository = prorrogaRepository;
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public Prorroga insertarProrroga(Long idProyecto, Prorroga prorroga) {
        Optional<Proyecto> proyectoOptional = proyectoRepository.obtenerProyecto(idProyecto);
        if (proyectoOptional.isPresent()) {
            Proyecto proyecto = proyectoOptional.get();
            if (proyecto.getEsPublico()){
                if (proyecto.getNumProrrogas() >= 2) return prorroga; //TODO falla al insertar 2 prorroga, falta poner error.
            }
            proyecto.setNumProrrogas(proyecto.getNumProrrogas() + 1);
            proyectoRepository.actualizarProyecto(idProyecto, proyecto);
        }
        return this.prorrogaRepository.insertarProrroga(idProyecto, prorroga);
    }

    @Override
    public List<Prorroga> obtenerProrrogas(Long idProyecto) {
        return this.prorrogaRepository.obtenerProrrogas(idProyecto);
    }

    @Override
    public Prorroga obtenerProrroga(Long idProrroga) {
        return this.prorrogaRepository.obtenerProrroga(idProrroga).get();
    }

    @Override
    public void actualizarProrroga(Long idProrroga, Prorroga prorroga) {
        this.prorrogaRepository.actualizarProrroga(idProrroga, prorroga);
    }

    @Override
    public void eliminarProrroga(Long idProrroga) {
        this.prorrogaRepository.eliminarProrroga(idProrroga);
    }
}
