package supuesto.aagonzalez.proyectos;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "supuesto.aagonzalez.proyectos")
@EntityScan(basePackages = "supuesto.aagonzalez.proyectos")
public class JpaConfig {
}
