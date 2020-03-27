package org.thibaut.thelibrary.service;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thibaut.thelibrary.dto.BookDTO;

@FeignClient(name = "THELIBRARY-MS-BOOK", fallbackFactory = BookFeignClientFallbackFactory.class)
public interface BookFeignClient {

	String AUTH_TOKEN = "Authorization";

	@GetMapping("/api/book/{id}")
	@Headers("Content-Type: application/json")
	public BookDTO findById( @PathVariable(name = "id") Long id);

}


