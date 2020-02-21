package org.thibaut.thelibrary.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thibaut.thelibrary.service.BookService;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.entity.LoanEntity;
import org.thibaut.thelibrary.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.restrepository.LoanRestRepository;
import org.thibaut.thelibrary.service.LoanService;
import org.thibaut.thelibrary.utils.RestPreconditions;
import org.thibaut.thelibrary.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@AllArgsConstructor
public class LoanController {

	private LoanRestRepository loanRepository;
	private BookService bookService;
	private LoanService loanService;
	private ApplicationEventPublisher eventPublisher;

	@GetMapping("/fullLoan/{id}")
	public LoanDTO getLoan( @PathVariable("id") Long id, HttpServletResponse response){
		try {
			final LoanDTO byId = loanService.findById( id );
			LoanDTO loanDTO = RestPreconditions.checkFound( byId );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return loanDTO;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Book not found", ex );
		}
	}
//
//
//	@GetMapping("/books")
//	public List<BookDTO> bookDTOList(HttpServletResponse response){
//		try {
//			List<BookDTO> bookDTOList = RestPreconditions.checkFound( bookService.getBookDTOList( ) );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
//			return bookDTOList;
//		}
//		catch ( ResourceNotFoundException ex ){
//			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "No book found", ex );
//		}
//	}
//
//
//	@PutMapping("/book")
//	public BookDTO update( @RequestBody BookDTO bookDTO, HttpServletResponse response ){
//		try {
//			RestPreconditions.checkFound( bookDTO );
//			BookDTO bookDTOToSave	= bookService.save( bookDTO );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
//			return bookDTOToSave;
//		}
//		catch ( ResourceNotFoundException ex ){
//			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Book to save is null", ex );
//		}
//	}
//
//
//	@DeleteMapping("/book")
//	public void delete( @PathVariable("id") Long id, HttpServletResponse response ){
//		try {
//			RestPreconditions.checkFound(  id );
//			bookService.delete( id );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
//		}
//		catch ( ResourceNotFoundException ex ){
//			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Book to delete is null", ex );
//		}
//	}
//
//
//	@DeleteMapping("/books/{idList}")
//	public void deleteList( @PathVariable("idList") List<Long> idList, HttpServletResponse response ){
//		try {
//			RestPreconditions.checkFound( idList );
//			bookService.deleteList( idList );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
//		}
//		catch ( ResourceNotFoundException ex ){
//			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Book list to delete is null", ex );
//		}
//	}
//
//
//	@DeleteMapping("/books")
//	public void deleteListWithBody( @RequestBody() List<Long> idList, HttpServletResponse response ){
//		try {
//			RestPreconditions.checkFound( idList );
//			bookService.deleteList( idList );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
//		}
//		catch ( ResourceNotFoundException ex ){
//			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Book list to delete is null", ex );
//		}
//	}
}
