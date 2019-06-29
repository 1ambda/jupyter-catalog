package jupyter.core.jdbc.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    // https://stackoverflow.com/questions/37281229/multiple-datasources-migrations-using-flyway-in-a-spring-boot-application
//    @Bean
//    FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
//        return new FlywayMigrationInitializer(flyway, (f) -> {
//        });
//    }
}
