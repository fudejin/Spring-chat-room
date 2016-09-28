package org.projectsforge.whisperer.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Database configuration.
 */
// declare the class as a configuration class
@Configuration
public class DatabaseConfig {

  /**
   * Embedded data source.
   *
   * @return the data source
   */
  @Bean(destroyMethod = "shutdown")
  // define the DataSource bean used to access database
  public DataSource embeddedDataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
  }

}
