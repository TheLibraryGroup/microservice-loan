package org.thibaut.thelibrary.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIdentityInfo( generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = SimpleMailMessageDTO.class )
public class SimpleMailMessageDTO {

	private String from;
	private String replyTo;
	private String to;
	private String[] cc;
	private String[] bcc;
	private Date sentDate;
	private String subject;
	private String text;
}
