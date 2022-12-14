package com.example.bacth.demobatch.job;

import com.example.bacth.demobatch.domain.CreditCardRisk;

import com.example.bacth.demobatch.repository.CreditCardRiskRespository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;
import java.util.List;
public class CreditCardItemWriter implements ItemWriter<CreditCardRisk> {

    @Autowired
    CreditCardRiskRespository respository;

    @Override
    public void write(List<? extends CreditCardRisk> list) throws Exception {
        respository.saveAll(list);
    }
}