package org.spring.example.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.spring.example.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
