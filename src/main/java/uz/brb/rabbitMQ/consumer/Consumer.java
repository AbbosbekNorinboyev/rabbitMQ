package uz.brb.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import uz.brb.rabbitMQ.config.RabbitMQConfig;
import uz.brb.rabbitMQ.dto.UserDto;

@Component
public class Consumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(UserDto userDto) {
        System.out.println("Qabul qilindi: " + userDto.getEmail());
    }
}
