package org.thibaut.thelibrary.entity;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

	private Long id;

	private String title;

	private String language;

	private Long isbn;

	private DateTime publicationDate;

	private Integer numberOfPages;

	private List< LoanEntity > loanList;


}
