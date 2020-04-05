package org.thibaut.thelibrary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDTO {

	private Long id;

	private String title;

	private String language;

}
