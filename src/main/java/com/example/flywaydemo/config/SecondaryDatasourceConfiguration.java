package com.example.flywaydemo.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Profile("!test")
@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo.repositories",
        includeFilters = @ComponentScan.Filter(Repository.class),
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDatasourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    public SecondaryDatasourceConfiguration(
            @Qualifier("secondaryDataSourceProperties") DataSourceProperties dataSourceProperties
    ) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "secondaryDatasource")
    public DataSource dataSource() {
        return dataSourceProperties.getDataSource();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            @Qualifier("secondaryDatasource") DataSource primaryDataSource
    ) {
        final var entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.example.demo.models");
        entityManagerFactoryBean.setDataSource(primaryDataSource);

        final var jpaProperties = new Properties();
        dataSourceProperties.generateProperties(jpaProperties);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean(name = "secondaryTransactionManager")
    public JpaTransactionManager primaryTransactionManager(
            @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        final var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
