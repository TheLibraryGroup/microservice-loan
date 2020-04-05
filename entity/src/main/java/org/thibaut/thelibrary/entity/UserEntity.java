package org.thibaut.thelibrary.entity;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntity {

	private Long id;

	private String firstName;
	private String lastName;
	private String userName;
	private DateTime registrationDate;

	private List< LoanEntity > loanList;


}
