package supuesto.aagonzalez.proyectos.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "esPublico")
    private Boolean esPublico;

    @Column(name = "numProrrogas")
    private Integer numProrrogas;

    @Column(name = "enGarantia")
    private Boolean enGarantia;

    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, targetEntity = ProrrogaEntity.class)
    private List<ProrrogaEntity> prorrogas;
}
