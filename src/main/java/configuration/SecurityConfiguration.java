package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by nazar on 11.04.17.
 */
@Configuration
@ComponentScan(basePackages= "configuration" )
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT login, password, enabled from \"users\" WHERE login=?"

                )
                .authoritiesByUsernameQuery(
                        "SELECT login, role FROM \"users\" WHERE login=?"

                );

    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/pre_logout").authenticated()
                .antMatchers("/instrument/*", "/dept/*", "/consultant/*").hasRole(ADMIN_ROLE)
                .antMatchers("/client/*", "/order/create").hasRole(CLIENT_ROLE)
                .antMatchers("/consultant/*","/order/create").hasRole(CONSULTANT_ROLE)

                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("lgn")
                .passwordParameter("pswd")
                .defaultSuccessUrl("/", false)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .rememberMe()
                .key("rem-me-key")
                .rememberMeParameter("ttx-remember-me")
                .rememberMeCookieName("ttx-remember-me")
                .tokenValiditySeconds(86400)
                .and()
                .sessionManagement()
                .maximumSessions(1).expiredUrl("/pre_logout")
                .and().and()
                .csrf().disable();
    }


    private static final String ADMIN_ROLE = "ADMIN";
    private static final String CLIENT_ROLE = "CLIENT";
    private static final String CONSULTANT_ROLE = "CONSULTANT";

}
