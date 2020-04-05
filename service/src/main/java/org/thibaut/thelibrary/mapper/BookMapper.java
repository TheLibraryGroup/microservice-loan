package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookMapper {

//	@Mappings({
//			@Mapping(target="id", source="id"),
//			@Mapping(target="title", source="title"),
//			@Mapping(target="language", source="language"),
//			@Mapping(target="isbn", source="isbn"),
//			@Mapping(target="publicationDate", source="publicationDate"),
//			@Mapping(target="lastUpdate", source="lastUpdate"),
//			@Mapping(target="numberOfPages", source="numberOfPages")
//	})
	BookDTO toDTO( BookEntity bookEntity );

	List< BookDTO > toDTOList( List< BookEntity > bookEntityList );

//	@Mappings({
//			@Mapping(target="id", source="id"),
//			@Mapping(target="title", source="title"),
//			@Mapping(target="language", source="language"),
//			@Mapping(target="isbn", source="isbn"),
//			@Mapping(target="publicationDate", source="publicationDate"),
//			@Mapping(target="lastUpdate", source="lastUpdate"),
//			@Mapping(target="numberOfPages", source="numberOfPages")
//	})
	BookEntity toEntity( BookDTO bookDTO );

	List< BookEntity > toEntityList( List< BookDTO > bookDTOList );

}
