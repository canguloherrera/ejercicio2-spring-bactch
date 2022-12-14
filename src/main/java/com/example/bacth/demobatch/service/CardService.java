package com.example.bacth.demobatch.service;

import com.example.bacth.demobatch.domain.CreditCard;
import com.example.bacth.demobatch.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CardService {
    @Autowired
    CreditCardRepository creditCardRepository;


    public void credicard() {
        CreditCard credicard = new CreditCard();
        credicard.setCardNumber(9991L);
        credicard.setLastPay(new Date());
        creditCardRepository.save(credicard);

    }

}
