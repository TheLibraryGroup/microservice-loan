package org.thibaut.thelibrary.entity.projection;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;
import org.thibaut.thelibrary.entity.LoanEntity;

@Projection(name = "loanProjection", types = LoanEntity.class )
public interface LoanProjection {

	public Long getId( );

	public DateTime getStartDate();
	public boolean isReturned();
	public DateTime getInitialEndDate();
	public DateTime getExtendedEndDate();

	public Long getBookId();

	public Long getUserId();
}
