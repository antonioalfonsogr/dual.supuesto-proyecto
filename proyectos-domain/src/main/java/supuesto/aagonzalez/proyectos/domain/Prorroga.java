package supuesto.aagonzalez.proyectos.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Prorroga {

    private Long idProrroga;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Double importe;

    private Proyecto proyecto;

}
