package web.mvc.config;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Log4j2
@Configuration
public class MyBatisConfig {

    @Bean
    public DataSource dataSource() {
        // 데이터베이스 연결 DataSource 를 설정
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("C##KwonDB2");
        dataSource.setPassword("tiger");

        // 로그 출력
        log.info("DataSource isReady ----------------------------------------------");

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(ResourcePatternResolver resourcePatternResolver) throws Exception {
        // SqlSessionFactory 를 설정
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());

        // 매퍼 파일 경로 설정
        // classpath:mapper/ 디렉토리 내의 모든 매퍼 파일을 스캔
        Resource[] resources = resourcePatternResolver.getResources("classpath*:mapper/*.xml");
        sqlSessionFactory.setMapperLocations(resources);

        // 로그 출력
        log.info("SqlSession isReady ---------------------------------------------");
        return sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        // SqlSessionTemplate 을 설정
        log.info("SqlSessionTemplate isReady -------------------------------------");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
