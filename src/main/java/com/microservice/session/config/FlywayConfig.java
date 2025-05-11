package com.microservice.session.config;

import com.microservice.session.config.properties.FlywayProperties;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class FlywayConfig {

    private final FlywayProperties flywayProperties;

    @Bean
    FlywayMigrationStrategy cleanMigrateStrategy(final DataSourceProperties dataSourceProperties) {
        // @off
        return (Flyway flyway) -> {
            flyway = Flyway.configure()
                    .dataSource(dataSourceProperties.getUrl().concat(flywayProperties.getOptions()), dataSourceProperties.getUsername(), dataSourceProperties.getPassword())
                    .load();
            flyway.migrate();
        };
        // @on
    }

}
