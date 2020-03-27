package org.thibaut.thelibrary.service;

import feign.Headers;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

@FeignClient(name = "THELIBRARY-MS-BOOK" /*, url = "localhost:8081/THELIBRARY-MS-BOOK"*/)
public interface BookFeignClient {

	String AUTH_TOKEN = "Authorization";

	@GetMapping("/api/book/{id}")
	@Headers("Content-Type: application/json")
	public BookDTO findById( @PathVariable(name = "id") Long id);

}


