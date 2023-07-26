package com.mahedi.strategydesignpatternoffers.config;

import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.repository.ShopRepository;
import com.mahedi.strategydesignpatternoffers.strategy.Offer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Offerfactory {

    Map<OfferType, Offer> map;
    private final ShopRepository shopRepository;

    public Offerfactory(Set<Offer> offerSet, ShopRepository shopRepository){
        this.shopRepository = shopRepository;
        createdOffersMap(offerSet);
    }

    private void createdOffersMap(Set<Offer> offers) {
        map=new HashMap<>();
        offers.forEach(offer -> map.put(offer.getOfferType(),offer));
    }
    public Offer getOfferfromshop(OfferType offerType)
    {
        return map.get(offerType);
    }
}
