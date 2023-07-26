package com.mahedi.strategydesignpatternoffers.strategy.method;

import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.strategy.Offer;
import org.springframework.stereotype.Component;

@Component
public class Coupon implements Offer {
    @Override
    public String getOffer() {
        return "You get 100$ Cupon!!!";
    }

    @Override
    public OfferType getOfferType() {
        return OfferType.COUPON;
    }
}
