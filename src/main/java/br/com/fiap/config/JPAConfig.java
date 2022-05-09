package br.com.fiap.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("br.com.fiap.repository")
@PropertySource("classpath:database.properties")
public class JPAConfig {

    private final Environment env;

    public JPAConfig(Environment env) {
        this.env = env;
    }

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(getDataSource());
        lcemfb.setPersistenceUnitName("Default");
        lcemfb.setPackagesToScan("br.com.fiap.entity");
        lcemfb.setJpaProperties(jpaProperties());
        return lcemfb;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }

    @Bean
    public DataSource getDataSource() {
        String driverClassName = env.getProperty("database.driverClassName");
        String url = env.getProperty("database.url");
        String username = env.getProperty("database.username");
        String password = env.getProperty("database.password");

        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager txManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }

    private Properties jpaProperties() {
        String dialect = env.getProperty("hibernate.dialect");
        String show_sql = env.getProperty("hibernate.show_sql");
        String format_sql = env.getProperty("hibernate.format_sql");
        String hbm2ddl = env.getProperty("hibernate.hbm2ddl.auto");
        String new_generator_mappings = env.getProperty("hibernate.id.new_generator_mappings");

        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", show_sql);
        properties.put("hibernate.format_sql", format_sql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.put("hibernate.id.new_generator_mappings", new_generator_mappings);
        return properties;
    }

}
