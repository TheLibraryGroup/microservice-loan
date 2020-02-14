package org.thibaut.thelibrary.entity.projection;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;
import org.thibaut.thelibrary.entity.LoanEntity;

import java.time.LocalDate;
import java.util.List;

@Projection(name = "loanProjection", types = LoanEntity.class )
public interface LoanProjection {

	public Long getId( );

	public LocalDate getStartDate();
	public boolean isRReturned();
	public LocalDate getInitialEndDate();
	public LocalDate getExtendedEndDate();

	public Long getBookId();

	public Long getUserId();
}
