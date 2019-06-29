package jupyter.core.jdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "jupyter.core.jdbc.domain.hub",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
@EnableTransactionManagement
public class DataSourceHubConfig {

    @Primary
    @Bean(name = "hubDataSource")
    @ConfigurationProperties("spring.jpa.datasource.hub")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    public Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();

        // Dialect
        props.put("hibernate.dialect", MySQL5Dialect.class.getName());

        // Naming Strategy
        props.put("hibernate.physical_naming_strategy", PhysicalNamingStrategyStandardImpl.class.getName());
        // props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());

        // DDL Generation
        props.put("hibernate.id.new_generator_mappings", "false");

        // other performance-related options
        props.put("hibernate.connection.provider_disables_autocommit", "true");
        props.put("hibernate.cache.use_second_level_cache", "false");
        props.put("hibernate.cache.use_query_cache", "false");
        props.put("hibernate.generate_statistics", "false");

        return props;
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("hubDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("jupyter.core.jdbc.domain.hub")
                .persistenceUnit("hub")
                .properties(jpaProperties())
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

}
