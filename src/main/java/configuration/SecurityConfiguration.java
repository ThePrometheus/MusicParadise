package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by nazar on 11.04.17.
 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource)
                .usersByUsernameQuery(

                )
                .authoritiesByUsernameQuery(

                );
*/
    }
    @Autowired
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(/*"/admin/**"*/"/")
                .hasAnyRole("ADMIN","CONSULTANT","CLIENT")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
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
                .key("rememberKey")
                .rememberMeParameter("remember_me_param")
                .rememberMeCookieName("remember_me_cookie")
                .tokenValiditySeconds(100000)
                .and()
                .sessionManagement()
                .maximumSessions(2).expiredUrl("/pre_logout")
                .and()
                .and()
                .csrf()
                .disable();

    }



}
