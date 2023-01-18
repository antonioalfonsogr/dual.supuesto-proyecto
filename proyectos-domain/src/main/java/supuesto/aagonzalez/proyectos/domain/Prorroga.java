package supuesto.aagonzalez.proyectos.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Prorroga {

    private Long idProrroga;

    private Date fechaInicio;

    private Date fechaFin;

    private Double importe;

    private Proyecto proyecto;

}
