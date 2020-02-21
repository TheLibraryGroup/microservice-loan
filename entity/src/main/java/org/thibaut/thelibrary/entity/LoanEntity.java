package org.thibaut.thelibrary.entity;

import lombok.*;
import org.joda.time.DateTime;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz")
	private DateTime startDate; /*IMPORTANT: use 'timestamp' type in postgresql for great compatibility*/

	private boolean returned;

	private DateTime initialEndDate;

	private DateTime extendedEndDate;

	private Long bookId;

	@Transient
	private BookEntity book;

	private Long userId;

	@Transient
	private UserEntity user;

}
