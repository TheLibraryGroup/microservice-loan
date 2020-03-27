package org.thibaut.thelibrary.service;

import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

@Component
//@Qualifier(value = "BookServiceFallback")
public class BookFeignClientFallback implements BookFeignClient {

	@Override
	public BookDTO findById(Long id ) {
		return BookDTO.builder()
				       .title( "Default book" )
				       .language( "Default language")
				       .build();
	}

//	@Override
//	public PagedModel< BookEntity > findAll( ) {
//		return null;
//	}
}
