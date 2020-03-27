package org.thibaut.thelibrary.entity;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "loan")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LoanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_generator")
	@SequenceGenerator(name="loan_generator", sequenceName = "loan_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

//	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz")
	private DateTime startDate; /*IMPORTANT: use 'timestamp' type in postgresql for great compatibility*/

	private Integer durationInDay;
	private Boolean extended;

	private boolean returned;

	private Long bookId;

	@Transient
	private BookEntity book;

	private Long userId;

	@Transient
	private UserEntity user;

}
