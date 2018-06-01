package com.zsh.demo.kafka.producer;

import com.zsh.demo.common.GlobalConfig;
import com.zsh.demo.domain.message.KafkaMessage;
import com.zsh.demo.util.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static com.zsh.demo.domain.message.KafkaMessage.buildFromBody;

@Component
@Slf4j
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean send(String topic, Object body) {
        boolean ret = true;
        KafkaMessage kafkaMessage = buildFromBody(body);
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, JSON.toJson(kafkaMessage));
        try {
            int SEND_WAIT_TIME = GlobalConfig.kafka.SEND_WAIT_TIME;
            listenableFuture.get(SEND_WAIT_TIME, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.info("消息发送失败: 错误{}, 消息{}", e, kafkaMessage);
            ret = false;
        }
        return ret;
    }
}
