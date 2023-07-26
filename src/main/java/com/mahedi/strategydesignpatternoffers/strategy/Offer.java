package com.mahedi.strategydesignpatternoffers.strategy;

import com.mahedi.strategydesignpatternoffers.enums.OfferType;

public interface Offer {
    String getOffer();

    OfferType getOfferType();
}
