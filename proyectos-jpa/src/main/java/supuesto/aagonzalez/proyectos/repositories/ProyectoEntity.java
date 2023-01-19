package supuesto.aagonzalez.proyectos.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyectos")
@EqualsAndHashCode()
public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto", unique = true, nullable = false)
    private Long idProyecto;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cuantia")
    private Double cuantia;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "esPublico")
    private Boolean esPublico;

    @Column(name = "numProrrogas")
    private Integer numProrrogas;

    @Column(name = "enGarantia")
    private Boolean enGarantia;

    @Column(name = "id_cliente")
    private Long idCliente;

    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, targetEntity = ProrrogaEntity.class)
    private List<ProrrogaEntity> prorrogas;
}
