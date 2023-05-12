package web.mvc.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import web.mvc.config.MyAppConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Log4j2
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletCxt) throws ServletException {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyAppConfig.class);

        // Set ServletContext before refresh()
        ac.setServletContext(servletCxt);
        ac.refresh();

        // Create and register DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("appServlet", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        // CharacterEncodingFilter
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic filterRegistration = servletCxt.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");

        // 로그 찍기
        log.info("UTF-8 isReady ----------------------------------------------------------------");

        servletCxt.addListener(new ContextLoaderListener(ac));

        // 로그 찍기
        log.info("MyWebApplicationInitializer isReady ------------------------------------------");
    }
}

