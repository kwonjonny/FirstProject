package web.mvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web.mvc")
@Log4j2
public class MyAppConfig implements WebMvcConfigurer {

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        log.info("UTF-8 isOk");

        return filter;
    }

    // servlet-context.xml java코드 대체
    // 이 설정은 Spring MVC의 주요 설정
    // ComponentScan 이 -> @Controller , @Service, @Repository, @Component
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        log.info("InternalResourceViewResolver created with prefix: /WEB-INF/views/ and suffix: .jsp ------------------------------------------");

        return resolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        log.info("Adding resource handlers------------------------------------------");

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
}
