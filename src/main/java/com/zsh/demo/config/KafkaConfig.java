package com.zsh.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.topic.demo}")
    private String kafkaDemoTopic;

    public String getDemoTopic() {
        return kafkaDemoTopic;
    }
}
