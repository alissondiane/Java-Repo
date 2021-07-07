package com.arteaga.practica03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.arteaga.practica03.services", "com.arteaga.practica03.aspect"})
@EnableAspectJAutoProxy
public class AppConfig {

}
