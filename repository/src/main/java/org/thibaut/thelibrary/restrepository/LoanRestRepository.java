package org.thibaut.thelibrary.restrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.thibaut.thelibrary.entity.LoanEntity;

@RepositoryRestResource
public interface LoanRestRepository extends JpaRepository< LoanEntity, Long > {
}
