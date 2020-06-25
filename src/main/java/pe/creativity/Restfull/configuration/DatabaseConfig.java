//package pe.creativity.Restfull.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import java.util.Properties;
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfig {
//
//    @Value("postgres")
//    private String dbUsername;
//
//    @Value("postgres")
//    private String dbPassword;
//
//    @Value("jdbc:postgresql://localhost:5432/postgres/public")
//    private String dbUrl;
//
//    @Value("org.postgresql.Driver")
//    private String dbDriverClassName;
//
//    @Value("${}")
//    private String dbSchema;
//
//    @Value("org.hibernate.dialect.PostgreSQLDialect")
//    private String hibernateDialect;
//
//    @Value("true")
//    private String hibernateShowSql;
//
//    @Value("com.mycompany.myproduct.data")
//    private String emPackagesToScan;
//
//    @Value("update")
//    private String hibernateHbm2ddlAuto;
//
//    @Autowired
//    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(dbDriverClassName);
//        dataSource.setUrl(dbUrl);
//        dataSource.setUsername(dbUsername);
//        dataSource.setPassword(dbPassword);
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        //anulamos aplication.properties
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//
//        entityManagerFactory.setPackagesToScan("entitymanager.packagesToScan");
//
//        // Vendor adapter
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//
//        // Hibernate properties
//        Properties additionalProperties = new Properties();
//        additionalProperties.put("hibernate.dialect", hibernateDialect);
//        additionalProperties.put("hibernate.show_sql", hibernateShowSql);
//        additionalProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
//        entityManagerFactory.setJpaProperties(additionalProperties);
//        additionalProperties.put("hibernate.default_schema", "dbo");
//
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//}
