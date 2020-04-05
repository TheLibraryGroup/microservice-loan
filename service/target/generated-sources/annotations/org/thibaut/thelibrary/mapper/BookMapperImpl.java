package org.thibaut.thelibrary.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.dto.BookDTO.BookDTOBuilder;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.entity.BookEntity.BookEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-02T10:55:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Ubuntu)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDTO(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.id( bookEntity.getId() );
        bookDTO.title( bookEntity.getTitle() );
        bookDTO.language( bookEntity.getLanguage() );

        return bookDTO.build();
    }

    @Override
    public List<BookDTO> toDTOList(List<BookEntity> bookEntityList) {
        if ( bookEntityList == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( bookEntityList.size() );
        for ( BookEntity bookEntity : bookEntityList ) {
            list.add( toDTO( bookEntity ) );
        }

        return list;
    }

    @Override
    public BookEntity toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.id( bookDTO.getId() );
        bookEntity.title( bookDTO.getTitle() );
        bookEntity.language( bookDTO.getLanguage() );

        return bookEntity.build();
    }

    @Override
    public List<BookEntity> toEntityList(List<BookDTO> bookDTOList) {
        if ( bookDTOList == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( bookDTOList.size() );
        for ( BookDTO bookDTO : bookDTOList ) {
            list.add( toEntity( bookDTO ) );
        }

        return list;
    }
}
