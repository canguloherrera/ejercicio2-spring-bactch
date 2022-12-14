package com.example.bacth.demobatch.job;

import com.example.bacth.demobatch.domain.CreditCard;
import com.example.bacth.demobatch.repository.CreditCardRepository;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.core.StepExecution;  // se agrego esta linea para corregir el error del step7

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Iterator;

public class CreditCardItemReader implements ItemReader<CreditCard> {

    @Autowired
    CreditCardRepository repository;

    private Iterator<CreditCard> usersIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        usersIterator = repository.findAll().iterator();
    }

    @Override
    public CreditCard read() {
        if (usersIterator != null && usersIterator.hasNext()) {
            return usersIterator.next();
        } else {
            return null;
        }
    }
}