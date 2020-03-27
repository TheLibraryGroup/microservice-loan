package org.thibaut.thelibrary.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import lombok.*;
import org.joda.time.DateTime;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//@JsonIdentityInfo( generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = LoanDTO.class )
public class LoanDTO {

	private Long id;

	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime startDate;
	private Integer durationInDay;
	private Boolean extended;

	private boolean returned = false;

	private Long bookId;

	private Long userId;

	private String email;

	private BookDTO book;

}
