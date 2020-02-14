package org.thibaut.thelibrary.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.LocalDate;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

//	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startDate;

	private boolean returned;

//	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime initialEndDate;
//	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime extendedEndDate;

	private Long bookId;

	private Long userId;

}
