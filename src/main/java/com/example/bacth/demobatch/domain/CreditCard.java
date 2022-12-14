package com.example.bacth.demobatch.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_number")
    private Long cardNumber;
    @Column(name = "last_pay")
    private Date lastPay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getLastPay() {
        return lastPay;
    }

    public void setLastPay(Date lastPay) {
        this.lastPay = lastPay;
    }


    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", lastPay=" + lastPay +
                '}';
    }

}
