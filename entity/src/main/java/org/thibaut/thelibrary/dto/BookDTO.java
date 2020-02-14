package org.thibaut.thelibrary.dto;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDTO {

	private Long id;

	private String title;

	private List< CategoryDTO > categorieList;

	private String language;

	private Long isbn;

	private DateTime publicationDate;

	private Integer numberOfPages;

	private List< AuthorDTO > authorList;

	private List< LibraryDTO > librarieList;

	private EditorDTO editor;

	private List< LoanDTO > loanList;
}
