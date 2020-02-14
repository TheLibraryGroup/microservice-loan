package org.thibaut.thelibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthorDTO {

	private Long id;

	private String firstName;
	private String lastName;
	private String nationality;

	@JsonIgnore
	private List< BookDTO > bookList;

}
