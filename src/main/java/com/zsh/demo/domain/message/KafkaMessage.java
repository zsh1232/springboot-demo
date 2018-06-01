package com.zsh.demo.domain.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KafkaMessage {
    private String id;
    private Object body;
    private Long time;

    public static KafkaMessage buildFromBody(Object body) {
        return KafkaMessage.builder()
                .id(UUID.randomUUID().toString())
                .body(body)
                .time(System.currentTimeMillis())
                .build();
    }
}
