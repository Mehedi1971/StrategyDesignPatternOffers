package com.mahedi.strategydesignpatternoffers.strategy.method;

import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.strategy.Offer;
import org.springframework.stereotype.Component;

@Component
public class Discount implements Offer {

    @Override
    public String getOffer() {
        return "You Get 10% Discount!!!";
    }

    @Override
    public OfferType getOfferType() {
        return OfferType.DISCOUNT;
    }
}
