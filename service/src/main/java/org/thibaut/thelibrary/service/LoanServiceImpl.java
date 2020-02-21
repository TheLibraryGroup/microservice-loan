package org.thibaut.thelibrary.service;

import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.mapper.BookMapper;
import org.thibaut.thelibrary.mapper.LoanMapper;
import org.thibaut.thelibrary.publisher.LoanPublisher;
import org.thibaut.thelibrary.restrepository.LoanRestRepository;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

	private LoanRestRepository loanRepository;
	private LoanPublisher loanPublisher;
	private BookService bookService;

	@Override
	public LoanDTO findById( Long id ) {
		final LoanDTO loanDTO = LoanMapper.INSTANCE.toDTO(
												loanRepository.findById( id )
												.orElseThrow( ResourceNotFoundException::new ) );
		loanDTO.setBook( BookMapper.INSTANCE.toDTO( bookService.findById( loanDTO.getBookId() ) ) );
		return loanDTO;
	}

//	public LoanDTO save( LoanDTO loanDto ){
//		loanRepository.save( LoanMapper.INSTANCE.toEntity( loanDto ) );
//		loanPublisher.publish( loanDto );
//		return loanDto;
//	}

}
