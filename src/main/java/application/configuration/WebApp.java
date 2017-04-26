package application.configuration;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan(basePackages = "application")
@PropertySource("classpath:db.properties")
@EnableCaching
@EnableWebMvc
//@EnableWebSecurity
public class WebApp extends  WebMvcConfigurerAdapter
{
    @Autowired
    private Environment environment;
    @Autowired
    private ConversionService conversionService;



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/pres/**").addResourceLocations("/pres/");
      //  super.addResourceHandlers(registry);


    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
      //  super.addViewControllers(registry);
    }
    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager();
    }

    //database


    @Bean
    public DataSource dataSource(){
        PGPoolingDataSource dataSource  =  new PGPoolingDataSource();
        dataSource.setUser(environment.getProperty("db.login"));
        dataSource.setPassword(environment.getProperty("db.password"));
        dataSource.setMaxConnections(Integer.valueOf(environment.getProperty("db.connections")));
        dataSource.setServerName(environment.getProperty("db.server.name"));
        dataSource.setDatabaseName(environment.getProperty("db.name"));


        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){

        return new JdbcTemplate(dataSource());
    }
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pres/views/");
        resolver.setSuffix(".jsp");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    @Bean
    public Md5PasswordEncoder passwordEncoder(){
        return new Md5PasswordEncoder();
    }

    @Bean
    public PlatformTransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}



