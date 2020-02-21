package org.thibaut.thelibrary.helper;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.service.BookService;
import org.thibaut.thelibrary.entity.LoanEntity;
import org.thibaut.thelibrary.restrepository.LoanRestRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbPopulator implements CommandLineRunner {


	private LoanRestRepository loanRepository;
	private BookService bookService;
	private RepositoryRestConfiguration restConfiguration;

	@Override
	public void run( String... args ) throws Exception {
		restConfiguration.exposeIdsFor( LoanEntity.class );
		deleteAllThenPopulate( );

	}

	private void deleteAllThenPopulate( ) {
		System.out.println( "CONSUMER APP RUN" );

		//-----CLEAN DB

		this.loanRepository.deleteAll( );

		bookService.findAll();
		//-----POPULATE LOAN

		List< LoanEntity > loanEntityList = new ArrayList<>( );

		for ( int i = 0; i < 10; i++ ) {
			loanEntityList.add( LoanEntity.builder( )
										.userId( 1L )
					                    .startDate( DateTime.now( ) )
					                    .bookId( 8L )
					                    .build( ) );
		}

		loanRepository.saveAll( loanEntityList );
	}
}
