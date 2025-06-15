package com.loan_eligibility_system_admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan_eligibility_system_any_queries.AnyQueries;


public interface UserQueryDataRepository extends JpaRepository<AnyQueries, Integer>{

}
