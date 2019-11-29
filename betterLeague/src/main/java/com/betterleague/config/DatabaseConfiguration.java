package com.betterleague.config;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableJpaRepositories("com.betterleague.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

    final private Logger log  = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Inject
    private Environment env = null;

    @Bean(destroyMethod = "close")
    DataSource dataSource(DataSourceProperties dataSourceProperties) throws PropertyVetoException {
        log.debug("Configuring Datasource");
        String jndiName = env.getProperty("spring.datasource.jndiName");

        if ((jndiName != null) && (!jndiName.isEmpty())) {
            JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
            dsLookup.setResourceRef(true);
            DataSource dataSource = dsLookup.getDataSource("java:comp/env/" + jndiName);
            return dataSource;
        }else {
            if (dataSourceProperties.getUrl() == null) {
                throw new ApplicationContextException("Database connection pool is not configured correctly");
            }
            String jdbcUrl = dataSourceProperties.getUrl();
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(dataSourceProperties.getDriverClassName());
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setUser(dataSourceProperties.getUsername());
            dataSource.setPassword(dataSourceProperties.getPassword());
            dataSource.setAcquireIncrement(1);
            dataSource.setIdleConnectionTestPeriod(60);
            dataSource.setMaxPoolSize(20);
            dataSource.setMaxStatements(50);
            dataSource.setMinPoolSize(10);
            return dataSource;
        }
    }

    @Bean
    Hibernate4Module hibernate4Module(){
        return new Hibernate4Module();
    }
}