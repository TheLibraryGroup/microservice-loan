package org.thibaut.thelibrary.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thibaut.thelibrary.entity.BookEntity;

@FeignClient(name = "THELIBRARY-MS-BOOK", fallback = BookServiceFallback.class)
public interface BookService {

	@GetMapping("/bookEntities/{id}")
	public BookEntity findById(@PathVariable(name = "id") Long id);

	@GetMapping("/bookEntities")
	public PagedModel<BookEntity> findAll();
}


