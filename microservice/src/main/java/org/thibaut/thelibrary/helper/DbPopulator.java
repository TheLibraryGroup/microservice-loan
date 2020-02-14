package org.thibaut.thelibrary.helper;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.entity.LoanEntity;
import org.thibaut.thelibrary.repository.LoanRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbPopulator implements CommandLineRunner {


	private LoanRepository loanRepository;


	@Override
	public void run( String... args ) throws Exception {

		deleteAllThenPopulate( );

	}

	private void deleteAllThenPopulate( ) {
		System.out.println( "CONSUMER APP RUN" );

		//-----CLEAN DB

		this.loanRepository.deleteAll( );


		//-----POPULATE LOAN

		List< LoanEntity > loanEntityList = new ArrayList<>( );

		for ( int i = 0; i < 10; i++ ) {
			loanEntityList.add( LoanEntity.builder( )
										.userId( 1L )
					                    .startDate( DateTime.now( ) )
					                    .bookId( 8L ).build( ) );
		}

		loanRepository.saveAll( loanEntityList );
	}
}
