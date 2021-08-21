package com.otienosamwel.springbootdemo.domain.repository;

import com.otienosamwel.springbootdemo.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
