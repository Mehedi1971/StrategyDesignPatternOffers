package com.mahedi.strategydesignpatternoffers.repository;

import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
    String findByOfferType(String offerType);
//    String getDataByOfferType(String offerType);
    String findByOfferType(OfferType offerType);
}
