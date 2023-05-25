package web.mvc.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import web.mvc.config.MyAppConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Log4j2
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    // WebApplicationInitializer 를 구현한 클래스로서 웹 애플리케이션 초기화를 담당

    @Override
    public void onStartup(ServletContext servletCxt) throws ServletException {

        // Spring web application configuration 로드
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyAppConfig.class);

        // refresh() 메소드를 호출하기 전에 ServletContext 를 설정
        ac.setServletContext(servletCxt);
        ac.refresh();

        // DispatcherServlet 을 생성하고 등록
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("appServlet", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        // CharacterEncodingFilter 를 설정
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic filterRegistration = servletCxt.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");

        // Spring Security 필터 추가
        DelegatingFilterProxy springSecurityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");
        servletCxt.addFilter("springSecurityFilterChain", springSecurityFilterChain)
                .addMappingForUrlPatterns(null, false, "/*");

        // 로그 출력
        log.info("UTF-8 isReady ----------------------------------------------------------------");

        // ContextLoaderListener 를 추가
        servletCxt.addListener(new ContextLoaderListener(ac));
        
        // 로그 출력
        log.info("MyWebApplicationInitializer isReady ------------------------------------------");
        log.info("springSecurityFilterChain isReady --------------------------------------------");
    }
}

