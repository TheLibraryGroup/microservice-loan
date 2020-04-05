package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.entity.LoanEntity;

import java.util.List;


@Mapper(componentModel = "spring")
public interface LoanMapper {

	LoanDTO toDTO( LoanEntity loanEntity );

	List< LoanDTO > toDTOList( List< LoanEntity > loanEntityList );

	LoanEntity toEntity( LoanDTO loanDTO );

	List< LoanEntity > toEntityList( List< LoanDTO > loanDTOList );

}
