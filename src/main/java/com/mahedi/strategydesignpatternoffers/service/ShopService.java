package com.mahedi.strategydesignpatternoffers.service;

import com.mahedi.strategydesignpatternoffers.model.Shop;

public interface ShopService {
    void saveOffer(Shop shop);

    Shop getShopById(Long shopId);


    String getShopByDiscount(String offerType);
}
