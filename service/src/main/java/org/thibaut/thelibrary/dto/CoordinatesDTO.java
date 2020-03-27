package org.thibaut.thelibrary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CoordinatesDTO {

	private Long id;

	private String street;
	private String streetNumber;
	private String additionalInformation;
	private String city;
	private Long postalCode;
	private String phone;
	private String email;

	private EditorDTO editor;

	private LibraryDTO library;

}
