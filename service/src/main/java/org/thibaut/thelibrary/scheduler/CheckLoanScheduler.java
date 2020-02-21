package org.thibaut.thelibrary.scheduler;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.publisher.LoanPublisher;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class CheckLoanScheduler {

	private LoanPublisher loanPublisher;

	@Scheduled(fixedRate = 10000)
	public void scheduleFixedRateTask() {
		System.out.println(
				"Fixed rate task - " + System.currentTimeMillis() / 1000);
		loanPublisher.publish( LoanDTO.builder().id( 1L ).userId( 99L ).build().toString() );
	}
}
