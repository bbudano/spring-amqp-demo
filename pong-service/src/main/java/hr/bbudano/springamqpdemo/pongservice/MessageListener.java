package hr.bbudano.springamqpdemo.pongservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    private final RabbitTemplate rabbitTemplate;

    public MessageListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void handleMessage(Message message) {
        log.info("Recieved message: {}", message);
        rabbitTemplate.convertAndSend(RabbitMqConfig.DIRECT_EXCHANGE_NAME,
                RabbitMqConfig.OUTBOUND_ROUTING_KEY,
                "Pong");
    }

}
