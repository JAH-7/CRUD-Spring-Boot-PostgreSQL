package pe.creativity.Restfull.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/Home").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/v1").authenticated()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                   // .loginPage("/log-in")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();
    }


}
