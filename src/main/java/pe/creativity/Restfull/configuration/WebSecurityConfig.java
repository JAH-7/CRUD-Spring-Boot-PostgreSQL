package pe.creativity.Restfull.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import pe.creativity.Restfull.security.CustomUserDetailsService;
//import pe.creativity.Restfull.security.JwtAutheticationTokenFilter;
//import pe.creativity.Restfull.security.JwtAuthorizationTokenFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

  // private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/Home","/hello/*","/v1/nota/add","/v1/notes").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/login","/v1/note/add/type2","/v1/nota/get/").permitAll()
                .antMatchers("/users/signin").permitAll()
                .antMatchers("/users/signout","/v2/*").permitAll()
              //  .antMatchers("/v2").authenticated()
                //no permitir a todos los demas
                .anyRequest().authenticated()
              //  .and()    retirar
             //   .formLogin()    retirar
                // .loginPage("/log-in")
          //      .permitAll()    retirar
                .and()
                .logout()
                .permitAll()
                .and();
                //.addFilter(new JwtAutheticationTokenFilter(authenticationManager()))
               // .addFilter(new JwtAuthorizationTokenFilter(authenticationManager()));;

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

    }


//    @Bean
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
