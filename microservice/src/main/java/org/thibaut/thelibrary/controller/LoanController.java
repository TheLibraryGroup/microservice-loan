package org.thibaut.thelibrary.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thibaut.thelibrary.service.BookFeignClient;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.service.LoanService;
import org.thibaut.thelibrary.utils.RestPreconditions;
import org.thibaut.thelibrary.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@AllArgsConstructor
public class LoanController {

	private BookFeignClient bookFeignClient;
	private LoanService loanService;
	private ApplicationEventPublisher eventPublisher;


	@GetMapping("/fullLoan/{id}")
	@PreAuthorize("hasAnyRole('admin', 'user')")
	public LoanDTO getLoan( @PathVariable("id") Long id, HttpServletResponse response){
		try {
			final LoanDTO loanDTO = RestPreconditions.checkFound( loanService.findById( id ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return loanDTO;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Loan not found", ex );
		}
	}


	@GetMapping("/loans")
	@PreAuthorize("hasAnyRole('admin', 'user')")
	public List< LoanDTO > findAll( HttpServletResponse response){
		try {
			final List<LoanDTO> loanDTOList = RestPreconditions.checkFound( loanService.findAll() );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return loanDTOList;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "No Loan found", ex );
		}
	}


	@GetMapping("/loans/ongoing")
	@PreAuthorize("hasAnyRole('admin')")
	public List< LoanDTO > findAllByReturnedIsFalse( ){
		try {
			final List<LoanDTO> loanDTOList = RestPreconditions.checkFound( loanService.findAllByReturnedIsFalse() );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return loanDTOList;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "No Loan found", ex );
		}
	}


	@PostMapping("/loan")
	@PreAuthorize("hasAnyRole('admin')")
	public LoanDTO save( @RequestBody @NonNull LoanDTO loanDTO, HttpServletResponse response ){
		try {
			final LoanDTO loanDTOToSave = RestPreconditions.checkFound( loanService.save( loanDTO ) );
			loanService.publishLoanToBroker( loanDTO );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return loanDTOToSave;
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_ACCEPTABLE, "The Loan to save is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The Loan could not be saved", ex );
		}
	}


	@DeleteMapping("/loan")
	@PreAuthorize("hasAnyRole('admin')")
	public void delete( @PathVariable("id") @NonNull Long id, HttpServletResponse response ){
		try {
			loanService.deleteById( id );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_ACCEPTABLE, "The Loan ID to delete is null", ex );
		}
	}


	@DeleteMapping("/loans")
	@PreAuthorize("hasAnyRole('admin')")
	public void deleteList( @RequestBody() @NonNull List<Long> idList, HttpServletResponse response ){
		try {
			loanService.deleteByIdList( RestPreconditions.checkNotEmpty( idList ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_ACCEPTABLE, "The Loan list to delete is null", ex );
		}
		catch ( IllegalArgumentException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_ACCEPTABLE, "The Loan list to delete is empty", ex );
		}
	}

}
