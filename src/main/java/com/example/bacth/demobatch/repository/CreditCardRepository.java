package com.example.bacth.demobatch.repository;

import com.example.bacth.demobatch.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {

}
