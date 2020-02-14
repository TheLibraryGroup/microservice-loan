package org.thibaut.thelibrary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CategoryDTO {

	private Long id;

	private String category;
}
