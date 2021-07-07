package com.arteaga.practica02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.arteaga.practica02.service", "com.arteaga.practica02.aspect"})
@EnableAspectJAutoProxy
public class AppConfig {

}
