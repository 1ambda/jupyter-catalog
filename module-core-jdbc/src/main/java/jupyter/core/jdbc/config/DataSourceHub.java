package jupyter.core.jdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import jupyter.common.profile.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "jupyter.core.jdbc.domain.hub",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
@EnableTransactionManagement
public class DataSourceHub {

    @Autowired
    private Environment environment;

    @Primary
    @Bean(name = "hubDataSource")
    @ConfigurationProperties("datasource.hub.connection")
    public DataSource dataSource() {
        List<String> profiles = Arrays.asList(environment.getActiveProfiles());

        if (profiles.contains(ProfileManager.PROFILE_TEST_UNIT)) {
            return DataSourceBuilder.create().build();
        }

        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "hubDataSourceProps")
    @ConfigurationProperties("datasource.hub.properties")
    public DataSourceHubProps dataSourceHubProps() {
        return new DataSourceHubProps();
    }

    @Bean(name = "hubJpaProperties")
    public Map<String, Object> hubJpaProperties(DataSourceHubProps hubProps) {

        Map<String, Object> props = new HashMap<>();

        // Dialect
        props.put("hibernate.dialect", hubProps.getHibernateDialect());

        // Naming Strategy
        props.put("hibernate.physical_naming_strategy",
                hubProps.getHibernatePhysicalNamingStrategy());
        // props.put("hibernate.implicit_naming_strategy",
        //      hubProps.getHibernatePhysicalNamingStrategy());

        // DDL Generation
        props.put("hibernate.hbm2ddl.auto", hubProps.getHibernateHbm2ddlAuto());
        props.put("hibernate.id.new_generator_mappings", hubProps.getHibernateIdNewGeneratorMappings());

        // other performance-related options
        props.put("hibernate.connection.provider_disables_autocommit",
                hubProps.getHibernateConnectionProviderDisablesAutocommit());
        props.put("hibernate.cache.use_second_level_cache",
                hubProps.getHibernateCacheUseSecondLevelCache());
        props.put("hibernate.cache.use_query_cache",
                hubProps.getHibernateCacheUseQueryCache());

        // logging
        props.put("hibernate.format_sql", hubProps.getHibernateFormatSql());
        props.put("hibernate.generate_statistics", hubProps.getHibernateGenerateStatistics());
        props.put("hibernate.type", hubProps.getHibernateType());

        return props;
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("hubDataSource") DataSource dataSource) {

        DataSourceHubProps hubProps = dataSourceHubProps();
        Map<String, Object> jpaProperties = hubJpaProperties(hubProps);

        return builder
                .dataSource(dataSource)
                .packages("jupyter.core.jdbc.domain.hub")
                .persistenceUnit("hub")
                .properties(jpaProperties)
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
