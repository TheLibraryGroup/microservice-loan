package org.thibaut.thelibrary.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.dto.BookDTO.BookDTOBuilder;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.dto.LoanDTO.LoanDTOBuilder;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.entity.BookEntity.BookEntityBuilder;
import org.thibaut.thelibrary.entity.LoanEntity;
import org.thibaut.thelibrary.entity.LoanEntity.LoanEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-27T05:42:41+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Ubuntu)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public LoanDTO toDTO(LoanEntity loanEntity) {
        if ( loanEntity == null ) {
            return null;
        }

        LoanDTOBuilder loanDTO = LoanDTO.builder();

        loanDTO.id( loanEntity.getId() );
        loanDTO.startDate( loanEntity.getStartDate() );
        loanDTO.durationInDay( loanEntity.getDurationInDay() );
        loanDTO.extended( loanEntity.getExtended() );
        loanDTO.returned( loanEntity.isReturned() );
        loanDTO.bookId( loanEntity.getBookId() );
        loanDTO.userId( loanEntity.getUserId() );
        loanDTO.book( bookEntityToBookDTO( loanEntity.getBook() ) );

        return loanDTO.build();
    }

    @Override
    public List<LoanDTO> toDTOList(List<LoanEntity> loanEntityList) {
        if ( loanEntityList == null ) {
            return null;
        }

        List<LoanDTO> list = new ArrayList<LoanDTO>( loanEntityList.size() );
        for ( LoanEntity loanEntity : loanEntityList ) {
            list.add( toDTO( loanEntity ) );
        }

        return list;
    }

    @Override
    public LoanEntity toEntity(LoanDTO loanDTO) {
        if ( loanDTO == null ) {
            return null;
        }

        LoanEntityBuilder loanEntity = LoanEntity.builder();

        loanEntity.id( loanDTO.getId() );
        loanEntity.startDate( loanDTO.getStartDate() );
        loanEntity.durationInDay( loanDTO.getDurationInDay() );
        loanEntity.extended( loanDTO.getExtended() );
        loanEntity.returned( loanDTO.isReturned() );
        loanEntity.bookId( loanDTO.getBookId() );
        loanEntity.book( bookDTOToBookEntity( loanDTO.getBook() ) );
        loanEntity.userId( loanDTO.getUserId() );

        return loanEntity.build();
    }

    @Override
    public List<LoanEntity> toEntityList(List<LoanDTO> loanDTOList) {
        if ( loanDTOList == null ) {
            return null;
        }

        List<LoanEntity> list = new ArrayList<LoanEntity>( loanDTOList.size() );
        for ( LoanDTO loanDTO : loanDTOList ) {
            list.add( toEntity( loanDTO ) );
        }

        return list;
    }

    protected BookDTO bookEntityToBookDTO(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.id( bookEntity.getId() );
        bookDTO.title( bookEntity.getTitle() );
        bookDTO.language( bookEntity.getLanguage() );

        return bookDTO.build();
    }

    protected BookEntity bookDTOToBookEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.id( bookDTO.getId() );
        bookEntity.title( bookDTO.getTitle() );
        bookEntity.language( bookDTO.getLanguage() );

        return bookEntity.build();
    }
}
