package org.thibaut.thelibrary.dto;

import lombok.*;
import org.joda.time.DateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LoanDTO {

	private Long id;

	private DateTime startDate;
	private boolean returned = false;
	private DateTime initialEndDate;
	private DateTime extendedEndDate;

	private Long bookId;

	private Long userId;

}
