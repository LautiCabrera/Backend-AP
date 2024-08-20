package Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationPropertiesConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;
    
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${spring.jpa.database-platform}")
    private String databasePlatform;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private String maximumPoolSize;
    
    @Value("${jwt.secret}")
    private String jwtSecret;
    
    @Value("${jwt.expiration}")
    private String jwtExpiration;
    
    @Value("${web.cors.allowed-origins}")
    private String corsAllowed;
    
}