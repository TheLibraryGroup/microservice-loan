package org.thibaut.thelibrary.service;

import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.LoanDTO;

public interface LoanService {
	LoanDTO findById( Long id );
}
