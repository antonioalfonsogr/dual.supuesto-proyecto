package supuesto.aagonzalez.proyectos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supuesto.aagonzalez.proyectos.domain.Proyecto;
import supuesto.aagonzalez.proyectos.domain.repository.ProyectoRepository;
import supuesto.aagonzalez.proyectos.domain.service.ProyectoService;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public Proyecto insertarProyecto(Proyecto proyecto) {
        return this.proyectoRepository.insertarProyecto(proyecto);
    }

    @Override
    public List<Proyecto> obtenerProyectos() {
        return this.proyectoRepository.obtenerProyecto();
    }

    @Override
    public Proyecto obtenerProyecto(Long idProyecto) {
        return this.proyectoRepository.obtenerProyecto(idProyecto).get();
    }

    @Override
    public void actualizarProyecto(Long idProyecto, Proyecto proyecto) {
        this.proyectoRepository.actualizarProyecto(idProyecto, proyecto);
    }

    @Override
    public void eliminarProyecto(Long idProyecto) {
        this.proyectoRepository.eliminarProyecto(idProyecto);
    }
}
