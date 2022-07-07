package javafsmongolfiere.javafsmongolfiere.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf().ignoringAntMatchers("/h2-console/**");

        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                .antMatchers("h2-console/**").permitAll()
                .antMatchers("/hotel/{id:[0-9]+}/update").hasRole("ADMIN")
                .mvcMatchers("/login", "/client/register").anonymous()
                .antMatchers("/hotel/{id:[0-9]+}/details", "/client/info").authenticated()
                .anyRequest().permitAll();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/mongolfiere/all")
                .failureUrl("/login?error=true")
            .and()
                .logout()
                //.logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/mongolfiere/all");


        return http.build();
    }

}
