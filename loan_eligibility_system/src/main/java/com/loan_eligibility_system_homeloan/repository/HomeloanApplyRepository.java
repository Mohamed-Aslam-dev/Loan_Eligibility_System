package com.loan_eligibility_system_homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan_eligibility_system_homeloan.beans.HomeloanApplyLoanDatas;

@Repository
public interface HomeloanApplyRepository extends JpaRepository<HomeloanApplyLoanDatas, Integer>{

}
