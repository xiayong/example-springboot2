package me.xiayong.example.springboot2.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author YongXia.
 * @since 1.0
 */
@Component
public class DemoSender implements ApplicationListener<ContextRefreshedEvent> {
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @Value("${application.kafka.topics}")
    private List<String> topics;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextEvent) {
        new Thread(() -> {
            while (true) {
                topics.parallelStream().forEach(topic -> {
                    try {
                        String data = String.format("{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\"}",
                                "id", UUID.randomUUID().toString().replaceAll("-", ""),
                                "info", "hello",
                                "timestamp", new Date());
                        this.kafkaTemplate.send(topic, data).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
