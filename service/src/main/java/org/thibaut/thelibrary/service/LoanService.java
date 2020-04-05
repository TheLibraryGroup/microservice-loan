package org.thibaut.thelibrary.service;

import lombok.NonNull;
import org.thibaut.thelibrary.dto.LoanDTO;

import java.util.List;

public interface LoanService {
	LoanDTO findById( Long id );

	List< LoanDTO > findAll( );

	List< LoanDTO > findAllByReturnedIsFalse( );

	LoanDTO save( LoanDTO loanDTO );

	void publishLoanToBroker( @NonNull LoanDTO loanDTO );

	void deleteById( Long id );

	void deleteByIdList( List< Long > idList );
}
