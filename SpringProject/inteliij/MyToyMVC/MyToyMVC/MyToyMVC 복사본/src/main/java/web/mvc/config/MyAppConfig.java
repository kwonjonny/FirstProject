package web.mvc.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import web.mvc.controller.auth.CustomAuthenticationSuccessHandler;
import web.mvc.service.auth.PasswordRequiredService;
import web.mvc.service.login.LoginService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web.mvc")
@Log4j2
public class MyAppConfig implements WebMvcConfigurer {
    // Spring MVC 설정을 담당하는 클래스

    // servlet-context.xml java코드 대체
    // 이 설정은 Spring MVC의 주요 설정
    // ComponentScan 이 -> @Controller , @Service, @Repository, @Component
    @Bean
    public InternalResourceViewResolver resolver() {
        // View Resolver를 설정
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        log.info("InternalResourceViewResolver isReady -----------------------------------------");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 파일 리소스 핸들러를 추가
        log.info("addResourceHandlers isReady --------------------------------------------------");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler(LoginService loginService, PasswordRequiredService passwordRequiredService) {
        // 커스텀 인증 성공 핸들러를 설정
        return new CustomAuthenticationSuccessHandler(loginService, passwordRequiredService);
    }
}
