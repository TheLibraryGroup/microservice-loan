package org.thibaut.thelibrary.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.dto.BookDTO;

@Component
@Slf4j
public class BookFeignClientFallbackFactory implements FallbackFactory<BookFeignClient> {

//	@Override
//	public BookDTO findById(Long id ) {
//		return BookDTO.builder()
//				       .title( "Default book" )
//				       .language( "Default language")
//				       .build();
//	}

	@Override
	public BookFeignClient create( Throwable throwable ) {
		return new BookFeignClient( ) {
			@Override
			public BookDTO findById( Long id ) {
				log.warn( "BookFeignClient fallback, caused by: " + throwable.getMessage() );
				return BookDTO.builder()
						       .title( "Book fallback" )
						       .build();
			}
		};
	}

//	@Override
//	public PagedModel< BookEntity > findAll( ) {
//		return null;
//	}
}
