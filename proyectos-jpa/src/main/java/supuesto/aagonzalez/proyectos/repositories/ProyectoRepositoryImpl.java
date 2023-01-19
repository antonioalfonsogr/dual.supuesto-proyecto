package supuesto.aagonzalez.proyectos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import supuesto.aagonzalez.proyectos.domain.Proyecto;
import supuesto.aagonzalez.proyectos.domain.repository.ProyectoRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {

    private final ProyectoCrudRepository proyectoCrudRepository;
    private final Converter converter;

    @Autowired
    public ProyectoRepositoryImpl(ProyectoCrudRepository proyectoCrudRepository, Converter converter) {
        this.proyectoCrudRepository = proyectoCrudRepository;
        this.converter = converter;
    }

    @Override
    public List<Proyecto> obtenerProyecto() {
        return this.converter.toProyectos((List<ProyectoEntity>) this.proyectoCrudRepository.findAll());
    }

    @Override
    public Optional<Proyecto> obtenerProyecto(Long idProyecto) {
        ProyectoEntity proyectoEntity = this.proyectoCrudRepository.findById(idProyecto).orElseThrow();
        return Optional.of(this.converter.toProyecto(proyectoEntity));
    }

    @Override
    public Proyecto insertarProyecto(Proyecto proyecto) {
        ProyectoEntity proyectoEntity = this.converter.toProyectoEntity(proyecto);
        return this.converter.toProyecto(this.proyectoCrudRepository.save(proyectoEntity));
    }

    @Override
    public void actualizarProyecto(Long idProyecto, Proyecto proyecto) {
        ProyectoEntity proyectoEntity = this.proyectoCrudRepository.findById(idProyecto).orElseThrow();
        proyectoEntity.setConcepto(proyecto.getConcepto());
        proyectoEntity.setDescripcion(proyecto.getDescripcion());
        proyectoEntity.setCuantia(proyecto.getCuantia());
        proyectoEntity.setFechaInicio(proyecto.getFechaInicio());
        proyectoEntity.setFechaFin(proyecto.getFechaFin());
        proyectoEntity.setEsPublico(proyecto.getEsPublico());
        proyectoEntity.setNumProrrogas(proyecto.getNumProrrogas());
        proyectoEntity.setEnGarantia(proyecto.getEnGarantia());
        this.converter.toProyecto(this.proyectoCrudRepository.save(proyectoEntity));
    }

    @Override
    public void eliminarProyecto(Long idProyecto) {
        ProyectoEntity proyectoEntity = this.proyectoCrudRepository.findById(idProyecto).orElseThrow();
        this.proyectoCrudRepository.deleteById(proyectoEntity.getIdProyecto());
    }

}
