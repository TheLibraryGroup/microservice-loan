package org.thibaut.thelibrary.publisher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.dto.SimpleMailMessageDTO;

import static org.thibaut.thelibrary.config.BrokerConfig.ROUTING_KEY;
import static org.thibaut.thelibrary.config.BrokerConfig.TOPIC_EXCHANGE_NAME;

@Component
@Slf4j
@AllArgsConstructor
public class LoanMailConfirmationPublisher {

	private final AmqpTemplate amqpTemplate;

	public void publishLoanConfirmation( SimpleMailMessageDTO mailMessage ) {
		amqpTemplate.convertAndSend(TOPIC_EXCHANGE_NAME,ROUTING_KEY, mailMessage);
	}
}
