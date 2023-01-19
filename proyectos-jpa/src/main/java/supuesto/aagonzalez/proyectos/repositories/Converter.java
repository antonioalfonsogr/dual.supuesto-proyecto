package supuesto.aagonzalez.proyectos.repositories;

import org.springframework.stereotype.Component;
import supuesto.aagonzalez.proyectos.domain.Proyecto;
import supuesto.aagonzalez.proyectos.domain.Prorroga;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    // PROYECTOS

    public Proyecto toProyecto(ProyectoEntity proyectoEntity) {

        Proyecto proyecto = new Proyecto();

        proyecto.setIdProyecto(proyectoEntity.getIdProyecto());
        proyecto.setConcepto(proyectoEntity.getConcepto());
        proyecto.setDescripcion(proyectoEntity.getDescripcion());
        proyecto.setCuantia(proyectoEntity.getCuantia());
        proyecto.setFechaInicio(proyectoEntity.getFechaInicio());
        proyecto.setFechaFin(proyectoEntity.getFechaFin());
        proyecto.setEsPublico(proyectoEntity.getEsPublico());
        proyecto.setNumProrrogas(proyectoEntity.getNumProrrogas());
        proyecto.setEnGarantia(proyectoEntity.getEnGarantia());
        if (proyectoEntity.getProrrogas() != null) {
            proyecto.setProrrogas(toProrrogas(proyectoEntity.getProrrogas()));
        } else {
            proyecto.setProrrogas(new ArrayList<>());
        }
        return proyecto;
    }

    public ProyectoEntity toProyectoEntity(Proyecto proyecto) {

        ProyectoEntity proyectoEntity = new ProyectoEntity();

        proyectoEntity.setIdProyecto(proyecto.getIdProyecto());
        proyectoEntity.setConcepto(proyecto.getConcepto());
        proyectoEntity.setDescripcion(proyecto.getDescripcion());
        proyectoEntity.setCuantia(proyecto.getCuantia());
        proyectoEntity.setFechaInicio(proyecto.getFechaInicio());
        proyectoEntity.setFechaFin(proyecto.getFechaFin());
        proyectoEntity.setEsPublico(proyecto.getEsPublico());
        proyectoEntity.setNumProrrogas(proyecto.getNumProrrogas());
        proyectoEntity.setEnGarantia(proyectoEntity.getEnGarantia());
        if (proyecto.getProrrogas() != null) {
            proyectoEntity.setProrrogas(toProrrogasEntities(proyecto.getProrrogas()));
        } else {
            proyectoEntity.setProrrogas(new ArrayList<>());
        }

        return proyectoEntity;
    }

    public List<Proyecto> toProyectos(List<ProyectoEntity> all) {
        List<Proyecto> proyectoList = new ArrayList<>();
        for (ProyectoEntity c : all) {
            proyectoList.add(toProyecto(c));
        }
        return proyectoList;
    }

    public List<ProyectoEntity> toProyectosEntities(List<Proyecto> all) {
        List<ProyectoEntity> proyectoEntityList = new ArrayList<>();
        for (Proyecto c : all) {
            proyectoEntityList.add(toProyectoEntity(c));
        }
        return proyectoEntityList;
    }

    // PRORROGAS

    public Prorroga toProrroga(ProrrogaEntity prorrogaEntity) {

        Prorroga prorroga = new Prorroga();

        prorroga.setIdProrroga(prorrogaEntity.getIdProrroga());
        prorroga.setFechaInicio(prorrogaEntity.getFechaInicio());
        prorroga.setFechaFin(prorrogaEntity.getFechaFin());
        prorroga.setImporte(prorrogaEntity.getImporte());
        if (prorroga.getProyecto() != null) {
            prorroga.setProyecto(toProyecto(prorrogaEntity.getProyecto()));
        } else {
            prorrogaEntity.setProyecto(new ProyectoEntity());
        }

        return prorroga;
    }

    public ProrrogaEntity toProrrogaEntity(Prorroga prorroga) {

        ProrrogaEntity prorrogaEntity = new ProrrogaEntity();

        prorrogaEntity.setIdProrroga(prorroga.getIdProrroga());
        prorrogaEntity.setFechaInicio(prorroga.getFechaInicio());
        prorrogaEntity.setFechaFin(prorroga.getFechaFin());
        prorrogaEntity.setImporte(prorroga.getImporte());
        if (prorroga.getProyecto() != null) {
            prorrogaEntity.setProyecto(toProyectoEntity(prorroga.getProyecto()));
        } else {
            prorrogaEntity.setProyecto(new ProyectoEntity());
        }

        return prorrogaEntity;
    }

    public List<Prorroga> toProrrogas(List<ProrrogaEntity> all) {
        List<Prorroga> prorrogaList = new ArrayList<>();
        for (ProrrogaEntity r : all) {
            prorrogaList.add(toProrroga(r));
        }
        return prorrogaList;
    }

    public List<ProrrogaEntity> toProrrogasEntities(List<Prorroga> all) {
        List<ProrrogaEntity> prorrogaEntityList = new ArrayList<>();
        for (Prorroga r : all) {
            prorrogaEntityList.add(toProrrogaEntity(r));
        }
        return prorrogaEntityList;
    }
}
