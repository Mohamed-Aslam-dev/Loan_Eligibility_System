package com.loan_eligibility_system_homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan_eligibility_system_homeloan.beans.HomeloanApplyDocuments;

public interface HomeloanDocumentsRepository extends JpaRepository<HomeloanApplyDocuments, Integer> {

}
