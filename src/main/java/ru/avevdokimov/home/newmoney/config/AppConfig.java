package ru.avevdokimov.home.newmoney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {


    @Bean(name = "jdbcTemplateAccess")
    public JdbcTemplate getJdbcTemplateAccess() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource4.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:ucanaccess://C:/temp/money_eng.mdb");
        dataSource.setUsername(null);
        dataSource.setPassword(null);

        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }
}
