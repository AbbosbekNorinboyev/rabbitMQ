package uz.brb.rabbitMQ.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import uz.brb.rabbitMQ.config.RabbitMQConfig;
import uz.brb.rabbitMQ.dto.UserDto;

@Service
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    public void send(UserDto userDto) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                userDto);
        System.out.println("Yuborildi: " + userDto.getEmail());
    }
}
