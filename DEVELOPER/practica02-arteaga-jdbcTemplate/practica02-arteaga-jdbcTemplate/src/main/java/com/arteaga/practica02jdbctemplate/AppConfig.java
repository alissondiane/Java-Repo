package com.arteaga.practica02jdbctemplate;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.arteaga.practica02jdbctemplate.service", "com.arteaga.practica02jdbctemplate.aspect"})
@EnableAspectJAutoProxy
public class AppConfig {

}
