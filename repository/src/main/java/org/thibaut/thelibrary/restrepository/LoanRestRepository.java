package org.thibaut.thelibrary.restrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.LoanEntity;

import java.util.List;

@Repository
public interface LoanRestRepository extends JpaRepository< LoanEntity, Long > {

	List<LoanEntity> findAllByReturnedIsFalse();
}
