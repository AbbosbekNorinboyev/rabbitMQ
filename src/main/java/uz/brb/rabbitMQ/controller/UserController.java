package uz.brb.rabbitMQ.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.brb.rabbitMQ.dto.UserDto;
import uz.brb.rabbitMQ.producer.Producer;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final Producer producer;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        producer.send(userDto);
        return ResponseEntity.ok("Foydalanuvchi saqlandi");
    }
}
