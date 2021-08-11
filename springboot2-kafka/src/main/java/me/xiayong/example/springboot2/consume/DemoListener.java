package me.xiayong.example.springboot2.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author YongXia.
 * @since 1.0
 */
@Component
@Slf4j
public class DemoListener {

    @KafkaListener(
            topics = "${application.kafka.topics}",
            groupId = "${application.kafka.consume.group-default:default}",
            concurrency = "${application.kafka.consume.concurrency:1}",
            containerFactory = "kafkaManualAckListenerContainerFactory")
    public void onMessage(Map<String, Object> msg, Acknowledgment ack) {
        log.info("received message: {}", msg);
        ack.acknowledge();
    }
}
