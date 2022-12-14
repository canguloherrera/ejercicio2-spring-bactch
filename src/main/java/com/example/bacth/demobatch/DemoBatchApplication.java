package com.example.bacth.demobatch;

import com.example.bacth.demobatch.domain.CreditCard;
import com.example.bacth.demobatch.domain.CreditCardRisk;
import com.example.bacth.demobatch.repository.CreditCardRepository;
import com.example.bacth.demobatch.repository.CreditCardRiskRespository;
import com.example.bacth.demobatch.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Date;

@SpringBootApplication()
public class DemoBatchApplication implements CommandLineRunner {
	@Autowired
	CreditCardRepository creditCardRepository;

	@Autowired
	CreditCardRiskRespository creditCardRiskRespository;

	public static void main(String[] args) {
		SpringApplication.run(DemoBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		CreditCard credicard = new CreditCard();
//		credicard.setCardNumber(9991L);
//		credicard.setLastPay(new Date());
//		creditCardRepository.save(credicard);
//
//		CreditCardRisk creditCardRisk = new CreditCardRisk(credicard,new Date(),-30);
//		creditCardRiskRespository.save(creditCardRisk);


	}
}
