package com.loan_eligibility_system_any_queries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnyQueriesRepository extends JpaRepository<AnyQueries, Integer>{
	
	Optional<AnyQueries> findByEmail(String email);

}
