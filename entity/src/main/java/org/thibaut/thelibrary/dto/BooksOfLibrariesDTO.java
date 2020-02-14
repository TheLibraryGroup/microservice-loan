package org.thibaut.thelibrary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BooksOfLibrariesDTO {

	private BookLibraryIdDTO id;

	private BookDTO book;

	private LibraryDTO library;

	private Integer stock;

}
