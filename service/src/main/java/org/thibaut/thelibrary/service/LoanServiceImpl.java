package org.thibaut.thelibrary.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.dto.SimpleMailMessageDTO;
import org.thibaut.thelibrary.mapper.LoanMapper;
import org.thibaut.thelibrary.publisher.LoanMailConfirmationPublisher;
import org.thibaut.thelibrary.restrepository.LoanRestRepository;

import java.util.List;

@Service
@Slf4j
//@AllArgsConstructor
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

	private final LoanRestRepository loanRepository;
	private final BookFeignClient bookFeignClient;
	private final LoanMailConfirmationPublisher loanMailConfirmationPublisher;
	private final LoanMapper loanMapper;

	@Value("${loan-duration}")
	private Integer loanDurationInDay;

//	private Duration loanDuration;
//
//	@PostConstruct
//	private void postConstruct() {^
//		loanDuration = Duration.standardDays( loanDurationInDay );
//	}

	@Override
	public LoanDTO findById( Long id ) {
		final LoanDTO loanDTO = loanMapper.toDTO(
												loanRepository.findById( id )
												.orElseThrow( ResourceNotFoundException::new ) );
		final BookDTO bookDTO = bookFeignClient.findById( loanDTO.getBookId( ) );
		loanDTO.setBook( bookDTO );
		return loanDTO;
	}


	@Override
	public List< LoanDTO > findAll( ){
		return loanMapper.toDTOList( loanRepository.findAll());
	}


	@Override
	public List< LoanDTO > findAllByReturnedIsFalse( ){
		return loanMapper.toDTOList( loanRepository.findAllByReturnedIsFalse());
	}


	@Override
	public LoanDTO save( LoanDTO loanDTO ){
		if(loanDTO.getId()==null){
			loanDTO.setStartDate( DateTime.now() );
			loanDTO.setDurationInDay( loanDurationInDay );
		}
		loanRepository.save( loanMapper.toEntity( loanDTO ) );
		//If the ID is not null, then it is a new loan, then it is send to the broker
		return loanDTO;
	}


	@Override
	public void publishLoanToBroker( @NonNull final LoanDTO loanDTO ) {
		if(loanDTO.getId()==null){

			final SimpleMailMessageDTO mailMessage = new SimpleMailMessageDTO();
			mailMessage.setTo( loanDTO.getEmail( ) );
			mailMessage.setSubject( "TheLibrary: loan confirmation" );
			mailMessage.setText( "Dear, please consider this as a loan confirmation of the book '" + bookFeignClient.findById( loanDTO.getBookId() ).getTitle() + "'. You must give it back to TheLibrary for the " + loanDTO.getStartDate().plusDays( loanDTO.getDurationInDay() ).toString( DateTimeFormat.forPattern("d MMMM, yyyy") ) + " at the latest. Please notice that it can be extended once. If so, you can keep the book for extra period of " + loanDTO.getDurationInDay() + " days. We hope you will enjoy this book! Thank you for having visited our library!"  );

			loanMailConfirmationPublisher.publishLoanConfirmation( mailMessage );
		}
	}


	@Override
	public void deleteById( Long id ){
		loanRepository.deleteById( id );
	}


	@Override
	public void deleteByIdList( List< Long > idList ){
		for ( Long id: idList ) {
			deleteById( id );
		}
	}

}
