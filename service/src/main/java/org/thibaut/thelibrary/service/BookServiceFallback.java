package org.thibaut.thelibrary.service;

import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.entity.BookEntity;

@Service
public class BookServiceFallback implements BookService {

	@Override
	public BookEntity findById( Long id ) {
		return BookEntity.builder()
				       .title( "Default book" )
				       .numberOfPages( 0 )
				       .language( "Default language")
				       .build();
	}

	@Override
	public PagedModel< BookEntity > findAll( ) {
		return null;
	}
}
