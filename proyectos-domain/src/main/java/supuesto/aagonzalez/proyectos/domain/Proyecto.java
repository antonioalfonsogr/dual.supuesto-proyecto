package supuesto.aagonzalez.proyectos.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Proyecto {

    private Long idProyecto;

    private String concepto;

    private String descripcion;

    private Double cuantia;

    private Date fechaInicio;

    private Date fechaFin;

    private Boolean esPublico;

    private Integer numProrrogas;

    private Boolean enGarantia;

    private List<Prorroga> prorrogas;

}
 