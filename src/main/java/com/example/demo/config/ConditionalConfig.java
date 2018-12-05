package com.example.demo.config;

import com.example.demo.condition.ManCondition;
import com.example.demo.condition.WomanCondition;
import com.example.demo.entity.Man;
import com.example.demo.entity.Woman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {

    @Bean
    @Conditional(value = ManCondition.class)
    public Man getMan() {
        return new Man();
    }

    @Bean
    @Conditional(WomanCondition.class)
    public Woman getWoman(){
        return new Woman();
    }
}
