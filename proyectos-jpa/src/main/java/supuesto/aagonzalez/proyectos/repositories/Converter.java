package supuesto.aagonzalez.proyectos.repositories;

import org.springframework.stereotype.Component;
import supuesto.aagonzalez.proyectos.domain.Proyecto;
import supuesto.aagonzalez.proyectos.domain.Prorroga;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    //TODO refactorizar

    // CLIENTES

    public Proyecto toCliente(ProyectoEntity clienteEntity) {

        Proyecto cliente = new Proyecto();

        cliente.setIdProyecto(clienteEntity.getIdProyecto());
        cliente.setNombre(clienteEntity.getNombre());
        cliente.setNif(clienteEntity.getNif());
        cliente.setDireccion(clienteEntity.getDireccion());
        cliente.setPais(clienteEntity.getPais());
        if (clienteEntity.getProrrogas() != null) {
            cliente.setRepresentantes(toRepesentantes(clienteEntity.getProrrogas()));
        } else {
            cliente.setRepresentantes(new ArrayList<>());
        }
        return cliente;
    }

    public ProyectoEntity toClienteEntity(Proyecto cliente) {

        ProyectoEntity clienteEntity = new ProyectoEntity();

        clienteEntity.setIdProyecto(cliente.getIdProyecto());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setNif(cliente.getNif());
        clienteEntity.setDireccion(cliente.getDireccion());
        clienteEntity.setPais(cliente.getPais());
        if (cliente.getRepresentantes() != null) {
            clienteEntity.setProrrogas(toRepesentantesEntities(cliente.getRepresentantes()));
        } else {
            clienteEntity.setProrrogas(new ArrayList<>());
        }

        return clienteEntity;
    }

    public List<Proyecto> toClientes(List<ProyectoEntity> all) {
        List<Proyecto> clienteList = new ArrayList<>();
        for (ProyectoEntity c : all) {
            clienteList.add(toCliente(c));
        }
        return clienteList;
    }

    public List<ProyectoEntity> toClientesEntities(List<Proyecto> all) {
        List<ProyectoEntity> clienteEntityList = new ArrayList<>();
        for (Proyecto c : all) {
            clienteEntityList.add(toClienteEntity(c));
        }
        return clienteEntityList;
    }

    // REPRESENTANTES

    public Prorroga toRepresentante(ProrrogaEntity representanteEntity) {

        Prorroga representante = new Prorroga();

        representante.setIdProrroga(representanteEntity.getIdProrroga());
        representante.setDescripcion(representanteEntity.getNombre());
        representante.setCuantia(representanteEntity.getTelefono());
        representante.setIdioma(representanteEntity.getIdioma());
        if (representante.getProyecto() != null) {
            representante.setProyecto(toCliente(representanteEntity.getProyecto()));
        } else {
            representanteEntity.setProyecto(new ProyectoEntity());
        }

        return representante;
    }

    public ProrrogaEntity toRepresentanteEntity(Prorroga representante) {

        ProrrogaEntity representanteEntity = new ProrrogaEntity();

        representanteEntity.setIdProrroga(representante.getIdProrroga());
        representanteEntity.setNombre(representante.getDescripcion());
        representanteEntity.setTelefono(representante.getCuantia());
        representanteEntity.setIdioma(representante.getIdioma());
        if (representante.getProyecto() != null) {
            representanteEntity.setProyecto(toClienteEntity(representante.getProyecto()));
        } else {
            representanteEntity.setProyecto(new ProyectoEntity());
        }

        return representanteEntity;
    }

    public List<Prorroga> toRepesentantes(List<ProrrogaEntity> all) {
        List<Prorroga> representanteList = new ArrayList<>();
        for (ProrrogaEntity r : all) {
            representanteList.add(toRepresentante(r));
        }
        return representanteList;
    }

    public List<ProrrogaEntity> toRepesentantesEntities(List<Prorroga> all) {
        List<ProrrogaEntity> representanteEntityListList = new ArrayList<>();
        for (Prorroga r : all) {
            representanteEntityListList.add(toRepresentanteEntity(r));
        }
        return representanteEntityListList;
    }
}
