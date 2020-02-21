package org.thibaut.thelibrary.publisher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.dto.LoanDTO;

import static org.thibaut.thelibrary.config.BrokerConfig.*;

@Slf4j
@AllArgsConstructor
@Component
public class LoanPublisher {

	private final RabbitTemplate rabbitTemplate;

	public void publish( String message ){
		log.info("Sending message...");
		rabbitTemplate.convertAndSend(message);
	}
}
