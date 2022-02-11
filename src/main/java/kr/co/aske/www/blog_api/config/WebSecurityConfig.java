package kr.co.aske.www.blog_api.config;

import kr.co.aske.www.blog_api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/user", "/api/login", "/api/user/token", "/api/sign-on").permitAll()
                .antMatchers("/").hasRole("user")
                .antMatchers("/admin").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/user")
                .defaultSuccessUrl("/api/user")
                .loginProcessingUrl("/api/login")
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/api/user")
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
