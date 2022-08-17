package hr.bbudano.springamqpdemo.pingservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(initialDelay = 2000L, fixedRate = 5000L)
    public void sendMessage() {
        rabbitTemplate.convertAndSend(RabbitMqConfig.DIRECT_EXCHANGE_NAME,
                RabbitMqConfig.OUTBOUND_ROUTING_KEY,
                "Ping");
    }

}
