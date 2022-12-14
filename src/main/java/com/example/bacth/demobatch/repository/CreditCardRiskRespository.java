package com.example.bacth.demobatch.repository;

import com.example.bacth.demobatch.domain.CreditCardRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRiskRespository extends JpaRepository<CreditCardRisk, Long> {
}
