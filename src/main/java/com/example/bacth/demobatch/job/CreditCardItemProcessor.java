package com.example.bacth.demobatch.job;

import com.example.bacth.demobatch.domain.CreditCard;
import com.example.bacth.demobatch.domain.CreditCardRisk;
import org.springframework.batch.item.ItemProcessor;
import static java.time.temporal.ChronoUnit.DAYS;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;



public class CreditCardItemProcessor implements ItemProcessor<CreditCard, CreditCardRisk> {

    @Override
    public CreditCardRisk process(CreditCard item) {

        LocalDate today = LocalDate.now();
        LocalDate lastDate = item.getLastPay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long daysBetween = DAYS.between(today, lastDate);

        int risk;
        if (daysBetween >= 20) {
            risk = CreditCardRisk.HIGH;
        } else if (daysBetween > 10) {
            risk = CreditCardRisk.LOW;;
        }else {
            risk = CreditCardRisk.NORMAL;;
        }

        return new CreditCardRisk(item, new Date(), risk);
    }
}