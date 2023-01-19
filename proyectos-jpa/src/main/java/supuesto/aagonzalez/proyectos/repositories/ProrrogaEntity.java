package supuesto.aagonzalez.proyectos.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prorrogas")
public class ProrrogaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idProrroga;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "importe")
    private Double importe;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProyectoEntity.class)
    @JoinColumn(nullable = false, name = "id_proyecto")
    private ProyectoEntity proyecto;


}
