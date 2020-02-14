package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.LoanEntity;

@Repository
public interface LoanRepository extends JpaRepository< LoanEntity, Long > {
}
