package supuesto.aagonzalez.proyectos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import supuesto.aagonzalez.proyectos.domain.Prorroga;
import supuesto.aagonzalez.proyectos.domain.repository.ProrrogaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProrrogaRepositoryImpl implements ProrrogaRepository {

    private final ProrrogaCrudRepository prorrogaCrudRepository;
    private final Converter converter;
    private final ProyectoCrudRepository proyectoCrudRepository;

    @Autowired
    public ProrrogaRepositoryImpl(ProrrogaCrudRepository prorrogaCrudRepository, Converter converter, ProyectoCrudRepository proyectoCrudRepository) {
        this.prorrogaCrudRepository = prorrogaCrudRepository;
        this.converter = converter;
        this.proyectoCrudRepository = proyectoCrudRepository;
    }

    @Override
    public List<Prorroga> obtenerProrrogas(Long idProyecto) {
        return this.converter.toRepesentantes((List<ProrrogaEntity>) this.prorrogaCrudRepository.findAll());
    }

    @Override
    public Optional<Prorroga> obtenerProrroga(Long idProrroga) {
        ProrrogaEntity prorrogaEntity = this.prorrogaCrudRepository.findById(idProrroga).orElseThrow();
        return Optional.of(this.converter.toRepresentante(prorrogaEntity));
    }

    @Override
    public Prorroga insertarProrroga(Long idProyecto, Prorroga prorroga) {
        ProrrogaEntity prorrogaEntity = this.converter.toRepresentanteEntity(prorroga);
        prorrogaEntity.setProyecto(proyectoCrudRepository.findById(idProyecto).orElseThrow());
        return this.converter.toRepresentante(this.prorrogaCrudRepository.save(prorrogaEntity));
    }

    @Override
    public void actualizarProrroga(Long idProrroga, Prorroga prorroga) {
        ProrrogaEntity prorrogaEntity = this.prorrogaCrudRepository.findById(idProrroga).orElseThrow();
        prorrogaEntity.setFechaInicio(prorroga.getFechaInicio());
        prorrogaEntity.setFechaFin(prorroga.getFechaFin());
        prorrogaEntity.setImporte(prorroga.getImporte());
        this.prorrogaCrudRepository.save(prorrogaEntity);
    }

    @Override
    public void eliminarProrroga(Long idProrroga) {
        ProrrogaEntity prorrogaEntity = this.prorrogaCrudRepository.findById(idProrroga).orElseThrow();
        this.prorrogaCrudRepository.deleteById(prorrogaEntity.getIdProrroga());
    }
}
