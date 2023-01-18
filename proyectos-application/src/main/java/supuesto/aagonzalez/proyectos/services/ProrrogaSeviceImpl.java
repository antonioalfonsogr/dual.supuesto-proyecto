package supuesto.aagonzalez.proyectos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supuesto.aagonzalez.proyectos.domain.Prorroga;
import supuesto.aagonzalez.proyectos.domain.repository.ProrrogaRepository;
import supuesto.aagonzalez.proyectos.domain.service.ProrrogaService;

import java.util.List;

@Service
public class ProrrogaSeviceImpl implements ProrrogaService {

    private final ProrrogaRepository prorrogaRepository;

    @Autowired
    public ProrrogaSeviceImpl(ProrrogaRepository prorrogaRepository) {
        this.prorrogaRepository = prorrogaRepository;
    }

    @Override
    public Prorroga insertarProrroga(Long idProyecto, Prorroga prorroga) {
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
