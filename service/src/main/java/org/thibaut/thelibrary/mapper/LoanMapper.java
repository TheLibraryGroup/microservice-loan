package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.entity.LoanEntity;

import java.util.List;


@Mapper
public interface LoanMapper {

	LoanMapper INSTANCE = Mappers.getMapper( LoanMapper.class );

	LoanDTO toDTO( LoanEntity loanEntity );

	List< LoanDTO > toDTOList( List< LoanEntity > loanEntityList );

	LoanEntity toEntity( LoanDTO loanDTO );

	List< LoanEntity > toEntityList( List< LoanDTO > loanDTOList );

}
