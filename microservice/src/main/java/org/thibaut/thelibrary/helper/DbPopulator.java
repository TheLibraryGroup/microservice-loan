package org.thibaut.thelibrary.helper;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.entity.LoanEntity;
import org.thibaut.thelibrary.restrepository.LoanRestRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbPopulator implements CommandLineRunner {

	@Value( "${loan-duration}" )
	private String loanDuration;

	private LoanRestRepository loanRepository;

	private RepositoryRestConfiguration restConfiguration;

	public DbPopulator( LoanRestRepository loanRepository, RepositoryRestConfiguration restConfiguration ) {
		this.loanRepository = loanRepository;
		this.restConfiguration = restConfiguration;
	}


	@Override
	public void run( String... args ) throws Exception {
		restConfiguration.exposeIdsFor( LoanEntity.class );
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
										.durationInDay( Integer.valueOf( loanDuration ) )
					                    .bookId( 1L )
					                    .build( ) );
		}
		for ( int i = 0; i < 10; i++ ) {
			loanEntityList.add( LoanEntity.builder( )
					                    .userId( 1L )
					                    .startDate( DateTime.now().minusMonths( 2 ) )
					                    .durationInDay( Integer.valueOf( loanDuration ) )
					                    .bookId( 2L )
					                    .build( ) );
		}

		loanRepository.saveAll( loanEntityList );
	}
}
