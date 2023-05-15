package web.mvc.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import web.mvc.controller.auth.CustomAuthenticationSuccessHandler;
import web.mvc.service.auth.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler, CustomAuthenticationProvider authenticationProvider) {
        this.successHandler =successHandler;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/logout", "/CreateUser",
                 "/ForgotPassword", "/waiting", "/create", "/resendCode").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .successHandler(successHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .headers()
                .cacheControl().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

}
