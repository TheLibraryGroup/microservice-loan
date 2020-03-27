package org.thibaut.thelibrary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EditorDTO {

	private Long id;
	private String name;

	private CoordinatesDTO coordinates;

//	private List< BookDTO > bookList;

}
