package org.thibaut.thelibrary.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignClientInterceptor implements RequestInterceptor {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String TOKEN_TYPE = "Bearer";

	@Override
	public void apply( RequestTemplate template) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getDetails() instanceof WebAuthenticationDetails ) {
			final String tokenValue = ( ( JwtAuthenticationToken ) authentication ).getToken( ).getTokenValue( );
			template.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, tokenValue ));
		}
	}
}
