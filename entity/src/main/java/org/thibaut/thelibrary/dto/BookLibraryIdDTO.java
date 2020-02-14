package org.thibaut.thelibrary.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookLibraryIdDTO implements Serializable {

	private Integer bookId;
	private Integer libraryId;

}
