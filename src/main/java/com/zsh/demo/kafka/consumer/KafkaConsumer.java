package com.zsh.demo.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.demo}")
    public void listen(ConsumerRecord<?, ?> record , Acknowledgment ack){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("收到消息： {}", message);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = "${spring.kafka.topic.consumer-offsets}")
    public void listenOffsets(ConsumerRecord<?, ?> record, Acknowledgment ack){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("收到consumer-offsets： {}", message);
            ack.acknowledge();
        }
    }
}
