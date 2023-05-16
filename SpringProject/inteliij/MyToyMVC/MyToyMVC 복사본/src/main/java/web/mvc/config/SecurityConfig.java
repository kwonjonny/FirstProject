package web.mvc.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import web.mvc.controller.auth.CustomAuthenticationSuccessHandler;
import web.mvc.service.auth.CustomAuthenticationProvider;

@Log4j2
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
    log.info("HttpSecurityIsOk");
    httpSecurity
        .csrf().disable()
        .authorizeRequests()
                .antMatchers("/", "/custom-login", "/logout", "/CreateUser",
                 "/forgotPassword", "/waiting", "/create", "/resendCode").permitAll()
                .anyRequest().authenticated()
        .and()
        .formLogin()
                .loginPage("/custom-login") // 커스텀 로그인 페이지 경로
                .usernameParameter("id")
                .successHandler(successHandler)
                .defaultSuccessUrl("/")
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
